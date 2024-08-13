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
      <el-form-item label="方案历史id" prop="planHistoryId">
        <el-input
          v-model="queryParams.planHistoryId"
          placeholder="请输入方案历史id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
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
      <el-form-item label="参保率" prop="insuranceRate">
        <el-input
          v-model="queryParams.insuranceRate"
          placeholder="请输入参保率"
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
      <el-form-item label="收缴率" prop="collectRate">
        <el-input
          v-model="queryParams.collectRate"
          placeholder="请输入收缴率"
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
      <el-form-item label="个人账户记账利率" prop="accountRate">
        <el-input
          v-model="queryParams.accountRate"
          placeholder="请输入个人账户记账利率"
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
      <el-form-item label="养老金增长率" prop="growth">
        <el-input
          v-model="queryParams.growth"
          placeholder="请输入养老金增长率"
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
          v-hasPermi="['system:index_year_his:add']"
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
          v-hasPermi="['system:index_year_his:edit']"
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
          v-hasPermi="['system:index_year_his:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:index_year_his:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="index_year_hisList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主键id" align="center" prop="id" />
      <el-table-column label="年份" align="center" prop="year" />
      <el-table-column label="方案历史id" align="center" prop="planHistoryId" />
      <el-table-column label="男职工退休年龄" align="center" prop="mRetire" />
      <el-table-column label="女职工退休年龄" align="center" prop="fRetire" />
      <el-table-column label="女干部退休年龄" align="center" prop="fcRetire" />
      <el-table-column label="参保率" align="center" prop="insuranceRate" />
      <el-table-column label="个人缴费率" align="center" prop="individualRate" />
      <el-table-column label="企业缴费率" align="center" prop="enterpriseRate" />
      <el-table-column label="收缴率" align="center" prop="collectRate" />
      <el-table-column label="在岗平均工资" align="center" prop="avgSalary" />
      <el-table-column label="个人账户记账利率" align="center" prop="accountRate" />
      <el-table-column label="过渡系数" align="center" prop="transition" />
      <el-table-column label="养老金增长率" align="center" prop="growth" />
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
            v-hasPermi="['system:index_year_his:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:index_year_his:remove']"
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

    <!-- 添加或修改测算方案参数历史表（按年）对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="年份" prop="year">
          <el-input v-model="form.year" placeholder="请输入年份" />
        </el-form-item>
        <el-form-item label="方案历史id" prop="planHistoryId">
          <el-input v-model="form.planHistoryId" placeholder="请输入方案历史id" />
        </el-form-item>
        <el-form-item label="男职工退休年龄" prop="mRetire">
          <el-input v-model="form.mRetire" placeholder="请输入男职工退休年龄" />
        </el-form-item>
        <el-form-item label="女职工退休年龄" prop="fRetire">
          <el-input v-model="form.fRetire" placeholder="请输入女职工退休年龄" />
        </el-form-item>
        <el-form-item label="女干部退休年龄" prop="fcRetire">
          <el-input v-model="form.fcRetire" placeholder="请输入女干部退休年龄" />
        </el-form-item>
        <el-form-item label="参保率" prop="insuranceRate">
          <el-input v-model="form.insuranceRate" placeholder="请输入参保率" />
        </el-form-item>
        <el-form-item label="个人缴费率" prop="individualRate">
          <el-input v-model="form.individualRate" placeholder="请输入个人缴费率" />
        </el-form-item>
        <el-form-item label="企业缴费率" prop="enterpriseRate">
          <el-input v-model="form.enterpriseRate" placeholder="请输入企业缴费率" />
        </el-form-item>
        <el-form-item label="收缴率" prop="collectRate">
          <el-input v-model="form.collectRate" placeholder="请输入收缴率" />
        </el-form-item>
        <el-form-item label="在岗平均工资" prop="avgSalary">
          <el-input v-model="form.avgSalary" placeholder="请输入在岗平均工资" />
        </el-form-item>
        <el-form-item label="个人账户记账利率" prop="accountRate">
          <el-input v-model="form.accountRate" placeholder="请输入个人账户记账利率" />
        </el-form-item>
        <el-form-item label="过渡系数" prop="transition">
          <el-input v-model="form.transition" placeholder="请输入过渡系数" />
        </el-form-item>
        <el-form-item label="养老金增长率" prop="growth">
          <el-input v-model="form.growth" placeholder="请输入养老金增长率" />
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
import { listIndex_year_his, getIndex_year_his, delIndex_year_his, addIndex_year_his, updateIndex_year_his } from "@/api/system/index_year_his";

export default {
  name: "Index_year_his",
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
      // 测算方案参数历史表（按年）表格数据
      index_year_hisList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        year: null,
        planHistoryId: null,
        mRetire: null,
        fRetire: null,
        fcRetire: null,
        insuranceRate: null,
        individualRate: null,
        enterpriseRate: null,
        collectRate: null,
        avgSalary: null,
        accountRate: null,
        transition: null,
        growth: null,
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
        planHistoryId: [
          { required: true, message: "方案历史id不能为空", trigger: "blur" }
        ],
        mRetire: [
          { required: true, message: "男职工退休年龄不能为空", trigger: "blur" }
        ],
        fRetire: [
          { required: true, message: "女职工退休年龄不能为空", trigger: "blur" }
        ],
        fcRetire: [
          { required: true, message: "女干部退休年龄不能为空", trigger: "blur" }
        ],
        insuranceRate: [
          { required: true, message: "参保率不能为空", trigger: "blur" }
        ],
        individualRate: [
          { required: true, message: "个人缴费率不能为空", trigger: "blur" }
        ],
        enterpriseRate: [
          { required: true, message: "企业缴费率不能为空", trigger: "blur" }
        ],
        collectRate: [
          { required: true, message: "收缴率不能为空", trigger: "blur" }
        ],
        avgSalary: [
          { required: true, message: "在岗平均工资不能为空", trigger: "blur" }
        ],
        accountRate: [
          { required: true, message: "个人账户记账利率不能为空", trigger: "blur" }
        ],
        transition: [
          { required: true, message: "过渡系数不能为空", trigger: "blur" }
        ],
        growth: [
          { required: true, message: "养老金增长率不能为空", trigger: "blur" }
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
    /** 查询测算方案参数历史表（按年）列表 */
    getList() {
      this.loading = true;
      listIndex_year_his(this.queryParams).then(response => {
        this.index_year_hisList = response.rows;
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
        planHistoryId: null,
        mRetire: null,
        fRetire: null,
        fcRetire: null,
        insuranceRate: null,
        individualRate: null,
        enterpriseRate: null,
        collectRate: null,
        avgSalary: null,
        accountRate: null,
        transition: null,
        growth: null,
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
      this.title = "添加测算方案参数历史表（按年）";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getIndex_year_his(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改测算方案参数历史表（按年）";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateIndex_year_his(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addIndex_year_his(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除测算方案参数历史表（按年）编号为"' + ids + '"的数据项？').then(function() {
        return delIndex_year_his(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/index_year_his/export', {
        ...this.queryParams
      }, `index_year_his_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
