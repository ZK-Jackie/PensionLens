<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
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
          v-hasPermi="['system:index_description:add']"
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
          v-hasPermi="['system:index_description:edit']"
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
          v-hasPermi="['system:index_description:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:index_description:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="index_descriptionList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主键id" align="center" prop="id" />
      <el-table-column label="退休年龄描述" align="center" prop="retireDescription" />
      <el-table-column label="参保率描述" align="center" prop="insureDescription" />
      <el-table-column label="个人缴费率描述" align="center" prop="individualRateDescription" />
      <el-table-column label="企业缴费率描述" align="center" prop="enterpriseRateDescription" />
      <el-table-column label="收缴率描述" align="center" prop="collectRateDescription" />
      <el-table-column label="在岗平均工资描述" align="center" prop="avgSalaryDescription" />
      <el-table-column label="个人账户记账利率描述" align="center" prop="accountRateDescription" />
      <el-table-column label="过渡系数描述" align="center" prop="transitionDescription" />
      <el-table-column label="养老金增长率描述" align="center" prop="growthDescription" />
      <el-table-column label="城镇化率描述" align="center" prop="urbanizationDescription" />
      <el-table-column label="就业率描述" align="center" prop="employmentRateDescription" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:index_description:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:index_description:remove']"
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

    <!-- 添加或修改测算方案参数描述表对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="退休年龄描述" prop="retireDescription">
          <el-input v-model="form.retireDescription" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="参保率描述" prop="insureDescription">
          <el-input v-model="form.insureDescription" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="个人缴费率描述" prop="individualRateDescription">
          <el-input v-model="form.individualRateDescription" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="企业缴费率描述" prop="enterpriseRateDescription">
          <el-input v-model="form.enterpriseRateDescription" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="收缴率描述" prop="collectRateDescription">
          <el-input v-model="form.collectRateDescription" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="在岗平均工资描述" prop="avgSalaryDescription">
          <el-input v-model="form.avgSalaryDescription" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="个人账户记账利率描述" prop="accountRateDescription">
          <el-input v-model="form.accountRateDescription" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="过渡系数描述" prop="transitionDescription">
          <el-input v-model="form.transitionDescription" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="养老金增长率描述" prop="growthDescription">
          <el-input v-model="form.growthDescription" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="城镇化率描述" prop="urbanizationDescription">
          <el-input v-model="form.urbanizationDescription" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="就业率描述" prop="employmentRateDescription">
          <el-input v-model="form.employmentRateDescription" type="textarea" placeholder="请输入内容" />
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
import { listIndex_description, getIndex_description, delIndex_description, addIndex_description, updateIndex_description } from "@/api/system/index_description";

export default {
  name: "Index_description",
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
      // 测算方案参数描述表表格数据
      index_descriptionList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        retireDescription: null,
        insureDescription: null,
        individualRateDescription: null,
        enterpriseRateDescription: null,
        collectRateDescription: null,
        avgSalaryDescription: null,
        accountRateDescription: null,
        transitionDescription: null,
        growthDescription: null,
        urbanizationDescription: null,
        employmentRateDescription: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        retireDescription: [
          { required: true, message: "退休年龄描述不能为空", trigger: "blur" }
        ],
        insureDescription: [
          { required: true, message: "参保率描述不能为空", trigger: "blur" }
        ],
        individualRateDescription: [
          { required: true, message: "个人缴费率描述不能为空", trigger: "blur" }
        ],
        enterpriseRateDescription: [
          { required: true, message: "企业缴费率描述不能为空", trigger: "blur" }
        ],
        collectRateDescription: [
          { required: true, message: "收缴率描述不能为空", trigger: "blur" }
        ],
        avgSalaryDescription: [
          { required: true, message: "在岗平均工资描述不能为空", trigger: "blur" }
        ],
        accountRateDescription: [
          { required: true, message: "个人账户记账利率描述不能为空", trigger: "blur" }
        ],
        transitionDescription: [
          { required: true, message: "过渡系数描述不能为空", trigger: "blur" }
        ],
        growthDescription: [
          { required: true, message: "养老金增长率描述不能为空", trigger: "blur" }
        ],
        urbanizationDescription: [
          { required: true, message: "城镇化率描述不能为空", trigger: "blur" }
        ],
        employmentRateDescription: [
          { required: true, message: "就业率描述不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询测算方案参数描述表列表 */
    getList() {
      this.loading = true;
      listIndex_description(this.queryParams).then(response => {
        this.index_descriptionList = response.rows;
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
        retireDescription: null,
        insureDescription: null,
        individualRateDescription: null,
        enterpriseRateDescription: null,
        collectRateDescription: null,
        avgSalaryDescription: null,
        accountRateDescription: null,
        transitionDescription: null,
        growthDescription: null,
        urbanizationDescription: null,
        employmentRateDescription: null
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
      this.title = "添加测算方案参数描述表";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getIndex_description(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改测算方案参数描述表";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateIndex_description(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addIndex_description(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除测算方案参数描述表编号为"' + ids + '"的数据项？').then(function() {
        return delIndex_description(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/index_description/export', {
        ...this.queryParams
      }, `index_description_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
