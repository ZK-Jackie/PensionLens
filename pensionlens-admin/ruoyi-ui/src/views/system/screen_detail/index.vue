<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="图表名称" prop="detailName">
        <el-input
          v-model="queryParams.detailName"
          placeholder="请输入图表名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="最小数据量单位" prop="minDataUnit">
        <el-input
          v-model="queryParams.minDataUnit"
          placeholder="请输入最小数据量单位"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是否含有多选按钮，N-否，Y-是" prop="isMultiOption">
        <el-input
          v-model="queryParams.isMultiOption"
          placeholder="请输入是否含有多选按钮，N-否，Y-是"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="最后更新人id" prop="lastUpdateUserId">
        <el-input
          v-model="queryParams.lastUpdateUserId"
          placeholder="请输入最后更新人id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="最后更新时间" prop="lastUpdateTime">
        <el-date-picker clearable
          v-model="queryParams.lastUpdateTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择最后更新时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:screen_detail:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:screen_detail:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:screen_detail:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:screen_detail:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="screen_detailList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="图表配置id" align="center" prop="detailId" />
      <el-table-column label="大屏id" align="center" prop="screenId" />
      <el-table-column label="图表位置" align="center" prop="detailSpot" />
      <el-table-column label="图表名称" align="center" prop="detailName" />
      <el-table-column label="最小数据量单位" align="center" prop="minDataUnit" />
      <el-table-column label="是否含有多选按钮，N-否，Y-是" align="center" prop="isMultiOption" />
      <el-table-column label="最后更新人id" align="center" prop="lastUpdateUserId" />
      <el-table-column label="最后更新时间" align="center" prop="lastUpdateTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.lastUpdateTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:screen_detail:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:screen_detail:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改大屏配置表对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="图表名称" prop="detailName">
          <el-input v-model="form.detailName" placeholder="请输入图表名称" />
        </el-form-item>
        <el-form-item label="最小数据量单位" prop="minDataUnit">
          <el-input v-model="form.minDataUnit" placeholder="请输入最小数据量单位" />
        </el-form-item>
        <el-form-item label="是否含有多选按钮，N-否，Y-是" prop="isMultiOption">
          <el-input v-model="form.isMultiOption" placeholder="请输入是否含有多选按钮，N-否，Y-是" />
        </el-form-item>
        <el-form-item label="最后更新人id" prop="lastUpdateUserId">
          <el-input v-model="form.lastUpdateUserId" placeholder="请输入最后更新人id" />
        </el-form-item>
        <el-form-item label="最后更新时间" prop="lastUpdateTime">
          <el-date-picker clearable
            v-model="form.lastUpdateTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择最后更新时间">
          </el-date-picker>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listScreen_detail, getScreen_detail, delScreen_detail, addScreen_detail, updateScreen_detail } from "@/api/system/screen_detail";

export default {
  name: "Screen_detail",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 大屏配置表表格数据
      screen_detailList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        detailName: null,
        minDataUnit: null,
        isMultiOption: null,
        lastUpdateUserId: null,
        lastUpdateTime: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        detailName: [
          { required: true, message: "图表名称不能为空", trigger: "blur" }
        ],
        minDataUnit: [
          { required: true, message: "最小数据量单位不能为空", trigger: "blur" }
        ],
        isMultiOption: [
          { required: true, message: "是否含有多选按钮，N-否，Y-是不能为空", trigger: "blur" }
        ],
        lastUpdateTime: [
          { required: true, message: "最后更新时间不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询大屏配置表列表 */
    getList() {
      this.loading = true;
      listScreen_detail(this.queryParams).then(response => {
        this.screen_detailList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        detailId: null,
        screenId: null,
        detailSpot: null,
        detailName: null,
        minDataUnit: null,
        isMultiOption: null,
        lastUpdateUserId: null,
        lastUpdateTime: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.detailId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加大屏配置表";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const detailId = row.detailId || this.ids
      getScreen_detail(detailId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改大屏配置表";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.detailId != null) {
            updateScreen_detail(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addScreen_detail(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const detailIds = row.detailId || this.ids;
      this.$modal.confirm('是否确认删除大屏配置表编号为"' + detailIds + '"的数据项？').then(function() {
        return delScreen_detail(detailIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/screen_detail/export', {
        ...this.queryParams
      }, `screen_detail_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
