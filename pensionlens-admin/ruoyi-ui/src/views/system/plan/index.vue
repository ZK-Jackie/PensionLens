<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="方案名称" prop="planName">
        <el-input
          v-model="queryParams.planName"
          placeholder="请输入方案名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="方案统筹区域" prop="planArea">
        <el-input
          v-model="queryParams.planArea"
          placeholder="请输入方案统筹区域"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="测算起始年份" prop="startYear">
        <el-input
          v-model="queryParams.startYear"
          placeholder="请输入测算起始年份"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="测算结束年份" prop="endYear">
        <el-input
          v-model="queryParams.endYear"
          placeholder="请输入测算结束年份"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="测算执行时间" prop="executeTime">
        <el-date-picker clearable
          v-model="queryParams.executeTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择测算执行时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="方案版本号" prop="planVersion">
        <el-input
          v-model="queryParams.planVersion"
          placeholder="请输入方案版本号"
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
      <el-form-item label="退休人员类型，对应RETIRE_PERSON_TYPE字典" prop="retirePersonTypes">
        <el-input
          v-model="queryParams.retirePersonTypes"
          placeholder="请输入退休人员类型，对应RETIRE_PERSON_TYPE字典"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="生育模式，对应BIRTH_MODE字典" prop="birthMode">
        <el-input
          v-model="queryParams.birthMode"
          placeholder="请输入生育模式，对应BIRTH_MODE字典"
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
          v-hasPermi="['system:plan:add']"
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
          v-hasPermi="['system:plan:edit']"
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
          v-hasPermi="['system:plan:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:plan:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="planList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="方案id" align="center" prop="id" />
      <el-table-column label="方案名称" align="center" prop="planName" />
      <el-table-column label="方案统筹区域" align="center" prop="planArea" />
      <el-table-column label="测算起始年份" align="center" prop="startYear" />
      <el-table-column label="测算结束年份" align="center" prop="endYear" />
      <el-table-column label="测算执行状态，对应EXECUTE_STATUS字典" align="center" prop="executeStatus" />
      <el-table-column label="测算执行时间" align="center" prop="executeTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.executeTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="方案版本号" align="center" prop="planVersion" />
      <el-table-column label="上一年度养老金累计结余" align="center" prop="lastYearSumSurplus" />
      <el-table-column label="退休人员类型，对应RETIRE_PERSON_TYPE字典" align="center" prop="retirePersonTypes" />
      <el-table-column label="生育模式，对应BIRTH_MODE字典" align="center" prop="birthMode" />
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
            v-hasPermi="['system:plan:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:plan:remove']"
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

    <!-- 添加或修改延迟退休测算计划表对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="方案名称" prop="planName">
          <el-input v-model="form.planName" placeholder="请输入方案名称" />
        </el-form-item>
        <el-form-item label="方案统筹区域" prop="planArea">
          <el-input v-model="form.planArea" placeholder="请输入方案统筹区域" />
        </el-form-item>
        <el-form-item label="测算起始年份" prop="startYear">
          <el-input v-model="form.startYear" placeholder="请输入测算起始年份" />
        </el-form-item>
        <el-form-item label="测算结束年份" prop="endYear">
          <el-input v-model="form.endYear" placeholder="请输入测算结束年份" />
        </el-form-item>
        <el-form-item label="测算执行时间" prop="executeTime">
          <el-date-picker clearable
            v-model="form.executeTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择测算执行时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="方案版本号" prop="planVersion">
          <el-input v-model="form.planVersion" placeholder="请输入方案版本号" />
        </el-form-item>
        <el-form-item label="上一年度养老金累计结余" prop="lastYearSumSurplus">
          <el-input v-model="form.lastYearSumSurplus" placeholder="请输入上一年度养老金累计结余" />
        </el-form-item>
        <el-form-item label="退休人员类型，对应RETIRE_PERSON_TYPE字典" prop="retirePersonTypes">
          <el-input v-model="form.retirePersonTypes" placeholder="请输入退休人员类型，对应RETIRE_PERSON_TYPE字典" />
        </el-form-item>
        <el-form-item label="生育模式，对应BIRTH_MODE字典" prop="birthMode">
          <el-input v-model="form.birthMode" placeholder="请输入生育模式，对应BIRTH_MODE字典" />
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
import { listPlan, getPlan, delPlan, addPlan, updatePlan } from "@/api/system/plan";

export default {
  name: "Plan",
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
      // 延迟退休测算计划表表格数据
      planList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        planName: null,
        planArea: null,
        startYear: null,
        endYear: null,
        executeStatus: null,
        executeTime: null,
        planVersion: null,
        lastYearSumSurplus: null,
        retirePersonTypes: null,
        birthMode: null,
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
        planName: [
          { required: true, message: "方案名称不能为空", trigger: "blur" }
        ],
        planArea: [
          { required: true, message: "方案统筹区域不能为空", trigger: "blur" }
        ],
        startYear: [
          { required: true, message: "测算起始年份不能为空", trigger: "blur" }
        ],
        endYear: [
          { required: true, message: "测算结束年份不能为空", trigger: "blur" }
        ],
        executeStatus: [
          { required: true, message: "测算执行状态，对应EXECUTE_STATUS字典不能为空", trigger: "change" }
        ],
        planVersion: [
          { required: true, message: "方案版本号不能为空", trigger: "blur" }
        ],
        retirePersonTypes: [
          { required: true, message: "退休人员类型，对应RETIRE_PERSON_TYPE字典不能为空", trigger: "blur" }
        ],
        birthMode: [
          { required: true, message: "生育模式，对应BIRTH_MODE字典不能为空", trigger: "blur" }
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
    /** 查询延迟退休测算计划表列表 */
    getList() {
      this.loading = true;
      listPlan(this.queryParams).then(response => {
        this.planList = response.rows;
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
        planName: null,
        planArea: null,
        startYear: null,
        endYear: null,
        executeStatus: null,
        executeTime: null,
        planVersion: null,
        lastYearSumSurplus: null,
        retirePersonTypes: null,
        birthMode: null,
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
      this.title = "添加延迟退休测算计划表";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getPlan(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改延迟退休测算计划表";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updatePlan(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addPlan(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除延迟退休测算计划表编号为"' + ids + '"的数据项？').then(function() {
        return delPlan(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/plan/export', {
        ...this.queryParams
      }, `plan_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
