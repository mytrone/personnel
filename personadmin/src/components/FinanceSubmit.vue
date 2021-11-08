<template>
	<el-tabs v-model="activeName" @tab-click="handleClick">

		<el-tab-pane label="报销发钱" name="first">
			<el-col :span="7" :push="1">
				<el-input v-model="inpuy" placeholder="员工"> </el-input>
			</el-col>
			<el-col :span="7" id="shuru1" :push="2">
				<el-row>
					<el-button type="primary" @click="getAtk()">查询</el-button>
				</el-row>
			</el-col>
			
			<el-table :data="tableData.slice((currentPage-1)*pagesize,currentPage*pagesize)" style="width: 100%"
				:header-cell-style="{'text-align':'center'}" :cell-style="{'text-align':'center'}">

				<el-table-column prop="reimburseId" label="序号" />
				<el-table-column prop="empId.empName" label="员工名" />

				<el-table-column prop="reimburseData" label="申请时间" :formatter="dateFormak" />
				<el-table-column prop="reimburseTitle" label="标题" />
				<el-table-column prop="reimburseMoney" label="总金额" />
				<el-table-column prop="reimburseState" label="状态" :formatter="dateSex2" />
				<el-table-column label="操作">
					<template #default="scope">
						<el-button type="primary" size="medium" @click="getAtw(scope.row)" style="margin:  0  auto;">确定
						</el-button>
					</template>
				</el-table-column>
			</el-table>
			<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange"
				layout="total, sizes, prev, pager, next, jumper" :page-size="pagesize" :page-sizes="[3, 6, 9]"
				:total="tableData.length">
			</el-pagination>
		</el-tab-pane>
		<el-tab-pane label="报销记录" name="second">
			<el-col :span="7" :push="1">
				<el-input v-model="inpuk" placeholder="输入标题"> </el-input>
			</el-col>
			<el-col :span="7" id="shuru1" :push="2">
				<el-row>
					<el-button type="primary" @click="getAt()">查询</el-button>
				</el-row>
			</el-col>
			<el-table :data="taku.slice((currentPage2-1)*pagesize2,currentPage2*pagesize2)" 
			style="width: 100%"
				:header-cell-style="{'text-align':'center'}" :cell-style="{'text-align':'center'}">
			
				<el-table-column prop="submitId" label="序号" />
				<el-table-column prop="submitDate" label="申请时间" :formatter="dateFormak" />
				<el-table-column prop="submitSum" label="总金额" />
				<el-table-column prop="submitSerial"  label="标题"/>
				
			</el-table>
			<el-pagination @size-change="handleSizeChang2" @current-change="handleCurrentChange2"
				layout="total, sizes, prev, pager, next, jumper" :page-size="pagesize2" :page-sizes="[3, 6, 9]"
				:total="taku.length">
			</el-pagination>
		</el-tab-pane>
	</el-tabs>
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
				inpuy: '',
				inpuk: '',
				activeName: 'first',
				tableData: [],
				currentPage: 1, //职位初始页
				pagesize: 5, //职位每页的数据
				currentPage2: 1, //职位初始页
				pagesize2: 5, //职位每页的数据
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
				financeSubmit: {
					submitId: '',
					empId: '',
					arcempId: '',
					submitSerial: '',
					submitSum: '',
					submitDate: '',
				},
				taku:[],


			}
		},
		methods: {
			dateSex2: function(row) {
				if (row.reimburseState === 1) {
					return '已通过'
				} else  {
					return '未通过'
				}
			},
			getAt() {
				// this.archivesEmp.empName=this.inpuy
				// 	this.archivesEmp.empsonCard=this.inpuy
				// 	this.archivesEmp.empsonBank=this.inpuy
				// ,this.archivesEmp
			  this.financeSubmit.submitSerial= this.inpuk
				this.axios.post("/subm/upSubmit",this.financeSubmit).then((res) => {
					this.taku = res;
					console.log(this.taku)
				}).catch(function() {

				})
			},
			getAtk() {
				// this.archivesEmp.empName=this.inpuy
				// 	this.archivesEmp.empsonCard=this.inpuy
				// 	this.archivesEmp.empsonBank=this.inpuy
				// ,this.archivesEmp
				this.archivesEmp.empName=this.inpuy
				this.axios.post("/subm/allSubmit",this.archivesEmp).then((res) => {
					this.tableData = res;
					console.log(this.tableData)
				}).catch(function() {
			
				})
			},
			dateFormak: function(row, column) { //表格时间规格的排列
				var date = row[column.property];

				if (date == undefined) {
					return ''
				}
				return moment(date).format("YYYY-MM-DD hh:mm:ss")

			},
			getAtw(row) {
				this.$confirm('继续吗?', '提示', {
					confirmButtonText: '确定',
					cancelButtonText: '取消',
					type: 'warning'
				}).then(() => {
				this.financeSubmit.submitId=row.reimburseId
				this.financeSubmit.empId=row.empId.empId
				this.financeSubmit.submitSum=row.reimburseMoney	
				this.financeSubmit.submitSerial=row.reimburseTitle				
				this.axios.post("/subm/addSubmit", this.financeSubmit).then((res) => {
								console.log(res)
							if (res === "ok") {
								this.$message.success("报销成功");
									this.getAt()
									this.getAtk()
							} else {
								this.$message.error("报销失败");
							}

						}).catch(function() {

						})
					
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
			handleSizeChange2: function(size) {
				this.pagesize2 = size;
			},
			handleCurrentChange2: function(currentPage) {
				this.currentPage2 = currentPage;
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

			this.getAtk()
			this.getAt()
		}
	}
</script>
