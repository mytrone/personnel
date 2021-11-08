<template>
	<el-tabs v-model="activeName" @tab-click="handleClick">
		
		<el-tab-pane label="发工资" name="first">
			<el-col :span="7" :push="1">
				<el-input v-model="inpuy" placeholder="请输入项目名查询"> </el-input>
			</el-col>
			<el-col :span="7" id="shuru1" :push="2">
				<el-row>
					<el-button type="primary" @click="getAt()">查询</el-button>
				</el-row>
			</el-col>
			<el-col :span="7" id="shuru1" :push="5">
				<el-row>
					<el-button type="primary" @click="getAtw()">工资发放</el-button>
				</el-row>
			</el-col>
			<el-table :data="tableData.slice((currentPage-1)*pagesize,currentPage*pagesize)" style="width: 100%"
			:header-cell-style="{'text-align':'center'}"
				:cell-style="{'text-align':'center'}"
			>
			
				<el-table-column prop="empId" label="序号" />
				<el-table-column prop="empName" label="员工名"  />
				<el-table-column prop="empsonCard" label="员工卡号" />
				<el-table-column prop="empsonBank" label="员工账号" />
				<el-table-column label="操作">
					<template #default="scope">
						<el-button type="primary" size="medium" @click="delDrugTj(scope.row),drawers=true"
							style="margin:  0  auto;">查看记录
						</el-button>
					</template>
				</el-table-column>
			</el-table>
			<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" layout="total, sizes, prev, pager, next, jumper"
											 :page-size="pagesize" :page-sizes="[3, 6, 9]" :total="tableData.length">
											</el-pagination>
		</el-tab-pane>
	</el-tabs>
	<el-dialog title="模板项目" v-model="drawers">
	
	
	
		<el-table ref="multipleTable" :data="sortr" tooltip-effect="dark" style="width:1050px;margin-top:8px;"
			height="350px"
			:header-cell-style="{'text-align':'center'}"
				:cell-style="{'text-align':'center'}"
			>
			<el-table-column label="序号" prop="salarysonId">
			</el-table-column>
			<el-table-column label="工资" prop="salarysonBasic">
			
			</el-table-column>
			<el-table-column label="时间" prop="salarysonDate" :formatter="dateFormak">
			</el-table-column>
	
		</el-table>
		<!-- <el-pagination :page-size="size2" @current-change="queryRecords" background
			layout="total,prev, pager, next,jumper" :total="total2" :current-page="pageNo2">
		</el-pagination> -->
	</el-dialog>
</template>

<script lang="ts">
	import {
		Timer
	} from '@element-plus/icons'
	import moment from 'moment'
	export default {
		components: {
			Timer,
		},
		data() {
			return {
				drawers:false,
				inpuy:'',
				activeName: 'first',
				tableData: [],
				sortr:[],
				currentPage: 1, //职位初始页
				pagesize: 5, //职位每页的数据
				archivesEmp: {
					empId: '',
					empName: '',
					empsonSex: '',
					empsonCard: '',
					empsonEmail: '',
					empsonTel: '',
					empsonBank: '',
					empsonEducation: '',
					empsonDay: '',
					empsonBirthday: '',
					topId: '',
				},
				financeSalaryson:{
						salarysonId:'',//id
						salarysonName:'',
						 salarysonExtra:'',//加班工资
						 salarysonBasic:'',//基本工资
						 salarysonPerf:'',//绩效工资
						salarysonSum:'',//总工资
						 salarysonBank:'',//账户
				}
			}
		},
		methods: {
			dateFormak: function(row, column) { //表格时间规格的排列
				var date = row[column.property];
			
				if (date == undefined) {
					return ''
				}
				return moment(date).format("YYYY-MM-DD hh:mm:ss")
			
			},
			delDrugTj(row){
				this.financeSalaryson.salarysonName=row.empName;
				console.log(this.financeSalaryson.salarysonName)
				this.axios.post("/salary/allSalarysh",this.financeSalaryson).then((res) => {
					this.sortr = res;
				}).catch(function() {
				
				})
			},
			getAt(){
			this.archivesEmp.empName=this.inpuy
				this.archivesEmp.empsonCard=this.inpuy
				this.archivesEmp.empsonBank=this.inpuy
				this.axios.post("/chenck/chencks",this.archivesEmp).then((res) => {
					this.tableData = res;
				}).catch(function() {
				
				})
			},
			getAtw(){
				this.$confirm('是否新增?', '提示', {
					confirmButtonText: '确定',
					cancelButtonText: '取消',
					type: 'warning'
				}).then(() => {
					for (var i = 0; i < this.tableData.length; i++) {
						this.financeSalaryson.salarysonName = this.tableData[i].empName;
						this.financeSalaryson.salarysonBasic = this.tableData[i].empsonBasic;
						this.financeSalaryson.salarysonBank = this.tableData[i].empsonBank;
						this.axios.post("/salary/chencksTj", this.financeSalaryson).then((res) => {
					
							if (res === "ok") {
								this.$message.success("新增成功");
									this.getAt()
							} else {
								this.$message.error("新增失败");
							}
							
						}).catch(function() {
					
						})
					}
				}).catch(() => {
					this.$message({
						type: 'info',
						message: '已取消重置'
					});
				});
			},
			handleSizeChange: function(size) {
				this.pagesize = size;
			},
			handleCurrentChange: function(currentPage) {
				this.currentPage = currentPage;
			},
			handleClick(tab, event) {
				console.log(tab, event)
			},
			handleEdit(index, row) {
				console.log(index, row)
			},
			handleDelete(index, row) {
				console.log(index, row)
			},
		},
		created() {

			this.getAt()
		}
	}
</script>
