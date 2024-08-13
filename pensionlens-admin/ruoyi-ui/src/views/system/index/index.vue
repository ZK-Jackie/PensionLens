<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="男职工退休年龄" prop="mRetire">
        <el-input
          v-model="queryParams.mRetire"
          placeholder="请输入男职工退休年龄"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="女职工退休年龄" prop="fRetire">
        <el-input
          v-model="queryParams.fRetire"
          placeholder="请输入女职工退休年龄"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="女干部退休年龄" prop="fcRetire">
        <el-input
          v-model="queryParams.fcRetire"
          placeholder="请输入女干部退休年龄"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="在岗平均工资" prop="avgSalary">
        <el-input
          v-model="queryParams.avgSalary"
          placeholder="请输入在岗平均工资"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="个人缴费率" prop="individualRate">
        <el-input
          v-model="queryParams.individualRate"
          placeholder="请输入个人缴费率"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="企业缴费率" prop="enterpriseRate">
        <el-input
          v-model="queryParams.enterpriseRate"
          placeholder="请输入企业缴费率"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="参保率" prop="insuranceRate">
        <el-input
          v-model="queryParams.insuranceRate"
          placeholder="请输入参保率"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="养老金增长率" prop="growth">
        <el-input
          v-model="queryParams.growth"
          placeholder="请输入养老金增长率"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="收缴率" prop="collectRate">
        <el-input
          v-model="queryParams.collectRate"
          placeholder="请输入收缴率"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="过渡系数" prop="transition">
        <el-input
          v-model="queryParams.transition"
          placeholder="请输入过渡系数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="个人账户记账利率" prop="accountRate">
        <el-input
          v-model="queryParams.accountRate"
          placeholder="请输入个人账户记账利率"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="男职工计发月数" prop="mMonthly">
        <el-input
          v-model="queryParams.mMonthly"
          placeholder="请输入男职工计发月数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="女职工计发月数" prop="fMonthly">
        <el-input
          v-model="queryParams.fMonthly"
          placeholder="请输入女职工计发月数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="女干部计发月数" prop="fcMonthly">
        <el-input
          v-model="queryParams.fcMonthly"
          placeholder="请输入女干部计发月数"
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
          v-hasPermi="['system:index:add']"
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
          v-hasPermi="['system:index:edit']"
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
          v-hasPermi="['system:index:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:index:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="indexList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="统筹区域，对应t_yctxcs_area_code_dict的code值" align="center" prop="planArea" />
      <el-table-column label="年份" align="center" prop="year" />
      <el-table-column label="男职工退休年龄" align="center" prop="mRetire" />
      <el-table-column label="女职工退休年龄" align="center" prop="fRetire" />
      <el-table-column label="女干部退休年龄" align="center" prop="fcRetire" />
      <el-table-column label="在岗平均工资" align="center" prop="avgSalary" />
      <el-table-column label="个人缴费率" align="center" prop="individualRate" />
      <el-table-column label="企业缴费率" align="center" prop="enterpriseRate" />
      <el-table-column label="参保率" align="center" prop="insuranceRate" />
      <el-table-column label="养老金增长率" align="center" prop="growth" />
      <el-table-column label="收缴率" align="center" prop="collectRate" />
      <el-table-column label="过渡系数" align="center" prop="transition" />
      <el-table-column label="个人账户记账利率" align="center" prop="accountRate" />
      <el-table-column label="男职工计发月数" align="center" prop="mMonthly" />
      <el-table-column label="女职工计发月数" align="center" prop="fMonthly" />
      <el-table-column label="女干部计发月数" align="center" prop="fcMonthly" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:index:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:index:remove']"
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

    <!-- 添加或修改延迟退休测算方案默认参数表对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="男职工退休年龄" prop="mRetire">
          <el-input v-model="form.mRetire" placeholder="请输入男职工退休年龄" />
        </el-form-item>
        <el-form-item label="女职工退休年龄" prop="fRetire">
          <el-input v-model="form.fRetire" placeholder="请输入女职工退休年龄" />
        </el-form-item>
        <el-form-item label="女干部退休年龄" prop="fcRetire">
          <el-input v-model="form.fcRetire" placeholder="请输入女干部退休年龄" />
        </el-form-item>
        <el-form-item label="在岗平均工资" prop="avgSalary">
          <el-input v-model="form.avgSalary" placeholder="请输入在岗平均工资" />
        </el-form-item>
        <el-form-item label="个人缴费率" prop="individualRate">
          <el-input v-model="form.individualRate" placeholder="请输入个人缴费率" />
        </el-form-item>
        <el-form-item label="企业缴费率" prop="enterpriseRate">
          <el-input v-model="form.enterpriseRate" placeholder="请输入企业缴费率" />
        </el-form-item>
        <el-form-item label="参保率" prop="insuranceRate">
          <el-input v-model="form.insuranceRate" placeholder="请输入参保率" />
        </el-form-item>
        <el-form-item label="养老金增长率" prop="growth">
          <el-input v-model="form.growth" placeholder="请输入养老金增长率" />
        </el-form-item>
        <el-form-item label="收缴率" prop="collectRate">
          <el-input v-model="form.collectRate" placeholder="请输入收缴率" />
        </el-form-item>
        <el-form-item label="过渡系数" prop="transition">
          <el-input v-model="form.transition" placeholder="请输入过渡系数" />
        </el-form-item>
        <el-form-item label="个人账户记账利率" prop="accountRate">
          <el-input v-model="form.accountRate" placeholder="请输入个人账户记账利率" />
        </el-form-item>
        <el-form-item label="男职工计发月数" prop="mMonthly">
          <el-input v-model="form.mMonthly" placeholder="请输入男职工计发月数" />
        </el-form-item>
        <el-form-item label="女职工计发月数" prop="fMonthly">
          <el-input v-model="form.fMonthly" placeholder="请输入女职工计发月数" />
        </el-form-item>
        <el-form-item label="女干部计发月数" prop="fcMonthly">
          <el-input v-model="form.fcMonthly" placeholder="请输入女干部计发月数" />
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
import { listIndex, getIndex, delIndex, addIndex, updateIndex } from "@/api/system/index";

export default {
  name: "Index",
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
      // 延迟退休测算方案默认参数表表格数据
      indexList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        mRetire: null,
        fRetire: null,
        fcRetire: null,
        avgSalary: null,
        individualRate: null,
        enterpriseRate: null,
        insuranceRate: null,
        growth: null,
        collectRate: null,
        transition: null,
        accountRate: null,
        mMonthly: null,
        fMonthly: null,
        fcMonthly: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        mRetire: [
          { required: true, message: "男职工退休年龄不能为空", trigger: "blur" }
        ],
        fRetire: [
          { required: true, message: "女职工退休年龄不能为空", trigger: "blur" }
        ],
        fcRetire: [
          { required: true, message: "女干部退休年龄不能为空", trigger: "blur" }
        ],
        avgSalary: [
          { required: true, message: "在岗平均工资不能为空", trigger: "blur" }
        ],
        individualRate: [
          { required: true, message: "个人缴费率不能为空", trigger: "blur" }
        ],
        enterpriseRate: [
          { required: true, message: "企业缴费率不能为空", trigger: "blur" }
        ],
        insuranceRate: [
          { required: true, message: "参保率不能为空", trigger: "blur" }
        ],
        growth: [
          { required: true, message: "养老金增长率不能为空", trigger: "blur" }
        ],
        collectRate: [
          { required: true, message: "收缴率不能为空", trigger: "blur" }
        ],
        transition: [
          { required: true, message: "过渡系数不能为空", trigger: "blur" }
        ],
        accountRate: [
          { required: true, message: "个人账户记账利率不能为空", trigger: "blur" }
        ],
        mMonthly: [
          { required: true, message: "男职工计发月数不能为空", trigger: "blur" }
        ],
        fMonthly: [
          { required: true, message: "女职工计发月数不能为空", trigger: "blur" }
        ],
        fcMonthly: [
          { required: true, message: "女干部计发月数不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询延迟退休测算方案默认参数表列表 */
    getList() {
      this.loading = true;
      listIndex(this.queryParams).then(response => {
        this.indexList = response.rows;
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
        planArea: null,
        year: null,
        mRetire: null,
        fRetire: null,
        fcRetire: null,
        avgSalary: null,
        individualRate: null,
        enterpriseRate: null,
        insuranceRate: null,
        growth: null,
        collectRate: null,
        transition: null,
        accountRate: null,
        mMonthly: null,
        fMonthly: null,
        fcMonthly: null
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
      this.ids = selection.map(item => item.planArea)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加延迟退休测算方案默认参数表";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const planArea = row.planArea || this.ids
      getIndex(planArea).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改延迟退休测算方案默认参数表";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.planArea != null) {
            updateIndex(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addIndex(this.form).then(response => {
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
      const planAreas = row.planArea || this.ids;
      this.$modal.confirm('是否确认删除延迟退休测算方案默认参数表编号为"' + planAreas + '"的数据项？').then(function() {
        return delIndex(planAreas);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/index/export', {
        ...this.queryParams
      }, `index_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
