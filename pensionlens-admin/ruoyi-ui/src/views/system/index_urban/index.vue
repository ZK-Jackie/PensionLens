<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="年份" prop="year">
        <el-input
          v-model="queryParams.year"
          placeholder="请输入年份"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="年龄" prop="age">
        <el-input
          v-model="queryParams.age"
          placeholder="请输入年龄"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="方案id" prop="planId">
        <el-input
          v-model="queryParams.planId"
          placeholder="请输入方案id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="城镇化率" prop="urbanRate">
        <el-input
          v-model="queryParams.urbanRate"
          placeholder="请输入城镇化率"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是否删除，N-否，Y-是" prop="isDeleted">
        <el-input
          v-model="queryParams.isDeleted"
          placeholder="请输入是否删除，N-否，Y-是"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="插入人id" prop="insertUserId">
        <el-input
          v-model="queryParams.insertUserId"
          placeholder="请输入插入人id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="插入时间" prop="insertTime">
        <el-date-picker clearable
          v-model="queryParams.insertTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择插入时间">
        </el-date-picker>
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
      <el-form-item label="删除人id" prop="deleteUserId">
        <el-input
          v-model="queryParams.deleteUserId"
          placeholder="请输入删除人id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="删除时间" prop="deleteTime">
        <el-date-picker clearable
          v-model="queryParams.deleteTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择删除时间">
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
          v-hasPermi="['system:index_urban:add']"
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
          v-hasPermi="['system:index_urban:edit']"
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
          v-hasPermi="['system:index_urban:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:index_urban:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="index_urbanList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主键id" align="center" prop="id" />
      <el-table-column label="年份" align="center" prop="year" />
      <el-table-column label="年龄" align="center" prop="age" />
      <el-table-column label="方案id" align="center" prop="planId" />
      <el-table-column label="城镇化率" align="center" prop="urbanRate" />
      <el-table-column label="是否删除，N-否，Y-是" align="center" prop="isDeleted" />
      <el-table-column label="插入人id" align="center" prop="insertUserId" />
      <el-table-column label="插入时间" align="center" prop="insertTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.insertTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="最后更新人id" align="center" prop="lastUpdateUserId" />
      <el-table-column label="最后更新时间" align="center" prop="lastUpdateTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.lastUpdateTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="删除人id" align="center" prop="deleteUserId" />
      <el-table-column label="删除时间" align="center" prop="deleteTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.deleteTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:index_urban:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:index_urban:remove']"
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

    <!-- 添加或修改测算城镇化率参数表对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="年份" prop="year">
          <el-input v-model="form.year" placeholder="请输入年份" />
        </el-form-item>
        <el-form-item label="年龄" prop="age">
          <el-input v-model="form.age" placeholder="请输入年龄" />
        </el-form-item>
        <el-form-item label="方案id" prop="planId">
          <el-input v-model="form.planId" placeholder="请输入方案id" />
        </el-form-item>
        <el-form-item label="城镇化率" prop="urbanRate">
          <el-input v-model="form.urbanRate" placeholder="请输入城镇化率" />
        </el-form-item>
        <el-form-item label="是否删除，N-否，Y-是" prop="isDeleted">
          <el-input v-model="form.isDeleted" placeholder="请输入是否删除，N-否，Y-是" />
        </el-form-item>
        <el-form-item label="插入人id" prop="insertUserId">
          <el-input v-model="form.insertUserId" placeholder="请输入插入人id" />
        </el-form-item>
        <el-form-item label="插入时间" prop="insertTime">
          <el-date-picker clearable
            v-model="form.insertTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择插入时间">
          </el-date-picker>
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
        <el-form-item label="删除人id" prop="deleteUserId">
          <el-input v-model="form.deleteUserId" placeholder="请输入删除人id" />
        </el-form-item>
        <el-form-item label="删除时间" prop="deleteTime">
          <el-date-picker clearable
            v-model="form.deleteTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择删除时间">
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
import { listIndex_urban, getIndex_urban, delIndex_urban, addIndex_urban, updateIndex_urban } from "@/api/system/index_urban";

export default {
  name: "Index_urban",
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
      // 测算城镇化率参数表表格数据
      index_urbanList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        year: null,
        age: null,
        planId: null,
        urbanRate: null,
        isDeleted: null,
        insertUserId: null,
        insertTime: null,
        lastUpdateUserId: null,
        lastUpdateTime: null,
        deleteUserId: null,
        deleteTime: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        year: [
          { required: true, message: "年份不能为空", trigger: "blur" }
        ],
        age: [
          { required: true, message: "年龄不能为空", trigger: "blur" }
        ],
        planId: [
          { required: true, message: "方案id不能为空", trigger: "blur" }
        ],
        urbanRate: [
          { required: true, message: "城镇化率不能为空", trigger: "blur" }
        ],
        isDeleted: [
          { required: true, message: "是否删除，N-否，Y-是不能为空", trigger: "blur" }
        ],
        insertUserId: [
          { required: true, message: "插入人id不能为空", trigger: "blur" }
        ],
        insertTime: [
          { required: true, message: "插入时间不能为空", trigger: "blur" }
        ],
        lastUpdateTime: [
          { required: true, message: "最后更新时间不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询测算城镇化率参数表列表 */
    getList() {
      this.loading = true;
      listIndex_urban(this.queryParams).then(response => {
        this.index_urbanList = response.rows;
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
        id: null,
        year: null,
        age: null,
        planId: null,
        urbanRate: null,
        isDeleted: null,
        insertUserId: null,
        insertTime: null,
        lastUpdateUserId: null,
        lastUpdateTime: null,
        deleteUserId: null,
        deleteTime: null
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
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加测算城镇化率参数表";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getIndex_urban(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改测算城镇化率参数表";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateIndex_urban(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addIndex_urban(this.form).then(response => {
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
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除测算城镇化率参数表编号为"' + ids + '"的数据项？').then(function() {
        return delIndex_urban(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/index_urban/export', {
        ...this.queryParams
      }, `index_urban_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
