<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="方案历史id" prop="planHistoryId">
        <el-input
          v-model="queryParams.planHistoryId"
          placeholder="请输入方案历史id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="年份" prop="year">
        <el-input
          v-model="queryParams.year"
          placeholder="请输入年份"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="养老金支出" prop="expense">
        <el-input
          v-model="queryParams.expense"
          placeholder="请输入养老金支出"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="养老金征缴收入" prop="income">
        <el-input
          v-model="queryParams.income"
          placeholder="请输入养老金征缴收入"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="养老金累计结余" prop="surplus">
        <el-input
          v-model="queryParams.surplus"
          placeholder="请输入养老金累计结余"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="上一年度养老金累计结余" prop="lastYearSumSurplus">
        <el-input
          v-model="queryParams.lastYearSumSurplus"
          placeholder="请输入上一年度养老金累计结余"
          clearable
          @keyup.enter.native="handleQuery"
        />
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
          v-hasPermi="['system:results_history:add']"
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
          v-hasPermi="['system:results_history:edit']"
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
          v-hasPermi="['system:results_history:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:results_history:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="results_historyList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主键id" align="center" prop="id" />
      <el-table-column label="方案历史id" align="center" prop="planHistoryId" />
      <el-table-column label="年份" align="center" prop="year" />
      <el-table-column label="养老金支出" align="center" prop="expense" />
      <el-table-column label="养老金征缴收入" align="center" prop="income" />
      <el-table-column label="养老金累计结余" align="center" prop="surplus" />
      <el-table-column label="上一年度养老金累计结余" align="center" prop="lastYearSumSurplus" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:results_history:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:results_history:remove']"
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

    <!-- 添加或修改结果预测历史表对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="方案历史id" prop="planHistoryId">
          <el-input v-model="form.planHistoryId" placeholder="请输入方案历史id" />
        </el-form-item>
        <el-form-item label="年份" prop="year">
          <el-input v-model="form.year" placeholder="请输入年份" />
        </el-form-item>
        <el-form-item label="养老金支出" prop="expense">
          <el-input v-model="form.expense" placeholder="请输入养老金支出" />
        </el-form-item>
        <el-form-item label="养老金征缴收入" prop="income">
          <el-input v-model="form.income" placeholder="请输入养老金征缴收入" />
        </el-form-item>
        <el-form-item label="养老金累计结余" prop="surplus">
          <el-input v-model="form.surplus" placeholder="请输入养老金累计结余" />
        </el-form-item>
        <el-form-item label="上一年度养老金累计结余" prop="lastYearSumSurplus">
          <el-input v-model="form.lastYearSumSurplus" placeholder="请输入上一年度养老金累计结余" />
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
import { listResults_history, getResults_history, delResults_history, addResults_history, updateResults_history } from "@/api/system/results_history";

export default {
  name: "Results_history",
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
      // 结果预测历史表表格数据
      results_historyList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        planHistoryId: null,
        year: null,
        expense: null,
        income: null,
        surplus: null,
        lastYearSumSurplus: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        planHistoryId: [
          { required: true, message: "方案历史id不能为空", trigger: "blur" }
        ],
        year: [
          { required: true, message: "年份不能为空", trigger: "blur" }
        ],
        expense: [
          { required: true, message: "养老金支出不能为空", trigger: "blur" }
        ],
        income: [
          { required: true, message: "养老金征缴收入不能为空", trigger: "blur" }
        ],
        surplus: [
          { required: true, message: "养老金累计结余不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询结果预测历史表列表 */
    getList() {
      this.loading = true;
      listResults_history(this.queryParams).then(response => {
        this.results_historyList = response.rows;
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
        planHistoryId: null,
        year: null,
        expense: null,
        income: null,
        surplus: null,
        lastYearSumSurplus: null
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
      this.title = "添加结果预测历史表";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getResults_history(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改结果预测历史表";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateResults_history(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addResults_history(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除结果预测历史表编号为"' + ids + '"的数据项？').then(function() {
        return delResults_history(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/results_history/export', {
        ...this.queryParams
      }, `results_history_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
