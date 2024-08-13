<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="方案优先级" prop="priority">
        <el-input
          v-model="queryParams.priority"
          placeholder="请输入方案优先级"
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
          v-hasPermi="['system:screen_plan:add']"
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
          v-hasPermi="['system:screen_plan:edit']"
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
          v-hasPermi="['system:screen_plan:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:screen_plan:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="screen_planList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="大屏id" align="center" prop="screenId" />
      <el-table-column label="方案id" align="center" prop="planId" />
      <el-table-column label="方案优先级" align="center" prop="priority" />
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
            v-hasPermi="['system:screen_plan:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:screen_plan:remove']"
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

    <!-- 添加或修改大屏绑定预测方案对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="方案优先级" prop="priority">
          <el-input v-model="form.priority" placeholder="请输入方案优先级" />
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
import { listScreen_plan, getScreen_plan, delScreen_plan, addScreen_plan, updateScreen_plan } from "@/api/system/screen_plan";

export default {
  name: "Screen_plan",
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
      // 大屏绑定预测方案表格数据
      screen_planList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        priority: null,
        lastUpdateUserId: null,
        lastUpdateTime: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        priority: [
          { required: true, message: "方案优先级不能为空", trigger: "blur" }
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
    /** 查询大屏绑定预测方案列表 */
    getList() {
      this.loading = true;
      listScreen_plan(this.queryParams).then(response => {
        this.screen_planList = response.rows;
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
        screenId: null,
        planId: null,
        priority: null,
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
      this.ids = selection.map(item => item.screenId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加大屏绑定预测方案";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const screenId = row.screenId || this.ids
      getScreen_plan(screenId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改大屏绑定预测方案";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.screenId != null) {
            updateScreen_plan(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addScreen_plan(this.form).then(response => {
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
      const screenIds = row.screenId || this.ids;
      this.$modal.confirm('是否确认删除大屏绑定预测方案编号为"' + screenIds + '"的数据项？').then(function() {
        return delScreen_plan(screenIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/screen_plan/export', {
        ...this.queryParams
      }, `screen_plan_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
