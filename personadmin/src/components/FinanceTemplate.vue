<template>
	<el-row class="JNPF-common-search-box" :gutter="16">


	</el-row>
	<el-tabs v-model="activeName" @tab-click="handleClick">
		<el-tab-pane label="新建评分模板" name="first">
			<el-col :span="12">
				<el-button @click="drawer=true">
					查看模板项目
				</el-button>
			</el-col>
			<el-form :model="financeTemplate" ref="financeTemplate" :rules="treatmentCardRules">
				<el-col :span="6" :push="1">
					<el-form-item label="考核类别" :label-width="formLabelWidth" prop="alinkeyId">
						<el-select v-model="financeTemplate.alinkeyId" filterable placeholder="请选择模板类别"
							style="width: 150px;margin-bottom: 8px;margin-right: 800px;">
							<el-option v-for="item in sortw" :key="item.alinkeyId" :label="item.alinkeyName"
								:value="item.alinkeyId">
							</el-option>
						</el-select>
					</el-form-item>
				</el-col>
				<el-col :span="7" :push="1">
					<el-form-item label="模板名字" prop="templateName">
						<el-input v-model="financeTemplate.templateName"></el-input>
					</el-form-item>
				</el-col>
				<el-col :span="5" :push="4">
					<el-button @click="getTemplate()">
						确定
					</el-button>
				</el-col>
			</el-form>
			<el-table :data="financeTemplate.financeItem" style="width:100%"
				:header-cell-style="{'text-align':'center'}" :cell-style="{'text-align':'center'}">
				<el-table-column label="项目名" prop="itemId">

				</el-table-column>
				<el-table-column label="项目名" prop="itemName">

				</el-table-column>
				<el-table-column label="项目说明" prop="itemExplain">

				</el-table-column>
				<el-table-column label="操作">
					<template #default="scope">
						<el-button type="primary" size="medium" @click="delDrug2(scope.$index)"
							style="margin:  0  auto;">删除
						</el-button>
					</template>
				</el-table-column>
				
			</el-table>
		</el-tab-pane>
		<el-tab-pane label="查看模板" name="second">
			<el-form @submit.native.prevent>
				<el-col :span="12">
					<el-form-item >
						<el-input v-model="input" placeholder="请输入模板名与模板编号查询"> </el-input>
					</el-form-item>

				</el-col>
				<el-col :span="12" :push="1">
					<el-form-item>
						<el-button type="primary" @click="getKeyj()">查询</el-button>
					</el-form-item>
				</el-col>


				<el-table :data="getku.slice((currentPage-1)*pagesize,currentPage*pagesize)" style="width:100%" :header-cell-style="{'text-align':'center'}"
					:cell-style="{'text-align':'center'}">
					<el-table-column label="序号" prop="templateId">
					</el-table-column>
					<el-table-column label="类别" prop="alinkeyByAlinkeyId.alinkeyName">
					</el-table-column>
					<el-table-column label="创建人" prop="archivesEmpByEmpId.empName">
					</el-table-column>
					<el-table-column label="模板编号" prop="templateSerial">
					</el-table-column>
					<el-table-column label="创建时间" prop="templateDate" :formatter="dateFormak">
					</el-table-column>
					<el-table-column label="模板名" prop="templateName">
					</el-table-column>
					<el-table-column label="操作" width="230px">
						<template #default="scope">
							<el-button type="primary" size="medium" @click="delDrugw(scope.row)"
								style="margin:  0  auto;">删除
							</el-button>
							<el-button type="primary" size="medium" @click="delDrugws(scope.row),drawers=true"
								style="margin:  0  7;">查看
							</el-button>
						</template>
					</el-table-column>
					
				</el-table>
<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" layout="total, sizes, prev, pager, next, jumper"
								 :page-size="pagesize" :page-sizes="[3, 6, 9]" :total="getku.length">
								</el-pagination>

			</el-form>
		</el-tab-pane>
		<el-drawer title="项目列表" v-model="drawer" size="50%">
			<el-col :span="7" :push="1">
				<el-input v-model="financeItem.itemName" placeholder="请输入项目名查询"> </el-input>
			</el-col>
			<el-col :span="7" id="shuru1" :push="2">
				<el-row>
					<el-button type="primary" @click="getFinanceItem()">查询</el-button>
				</el-row>
			</el-col>
			<div style="height: 300px;">
				<el-table :data="item.slice((currentPage2-1)*pagesize2,currentPage2*pagesize2)" style="width:100%" :header-cell-style="{'text-align':'center'}"
					:cell-style="{'text-align':'center'}">
					<el-table-column label="序号" prop="itemId">
					</el-table-column>
					<el-table-column label="项目名" prop="itemName">

					</el-table-column>
					<el-table-column label="项目说明" prop="itemExplain">
					</el-table-column>
					<el-table-column label="操作">
						<template #default="scope">
							<el-button type="primary" size="medium" @click="delDrugTj(scope.row)"
								style="margin:  0  auto;">添加
							</el-button>
						</template>
					</el-table-column>
				</el-table>
				<el-pagination @size-change="handleSizeChange2" @current-change="handleCurrentChange2" layout="total, sizes, prev, pager, next, jumper"
												 :page-size="pagesize2" :page-sizes="[5, 10, 15]" :total="item.length">
												</el-pagination>
			</div>
		</el-drawer>
		<el-dialog title="模板项目" v-model="drawers">
		
		
		
			<el-table ref="multipleTable" :data="sortr" tooltip-effect="dark" style="width:1050px;margin-top:8px;"
				height="350px"
				:header-cell-style="{'text-align':'center'}"
					:cell-style="{'text-align':'center'}"
				>
				<el-table-column label="序号" prop="itemId">
				</el-table-column>
				<el-table-column label="项目名" prop="itemName">
				
				</el-table-column>
				<el-table-column label="项目说明" prop="itemExplain">
				</el-table-column>
		
			</el-table>
			<!-- <el-pagination :page-size="size2" @current-change="queryRecords" background
				layout="total,prev, pager, next,jumper" :total="total2" :current-page="pageNo2">
			</el-pagination> -->
		</el-dialog>
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
				input:'',
				currentPage: 1, //职位初始页
				pagesize: 5, //职位每页的数据
				currentPage2: 1, //职位初始页
				pagesize2: 5, //职位每页的数据
				activeName: 'first',
				drawer: false,
				query: '',
				getku:[],//模板数组
				tableData: [], //新增数组
				item: [], //考核项目查询数组
				sortw: [], //类别表数据
				sortr:[],//模板下的项目
				drawers:false,
				financeItem: {
					itemId: '', //id
					itemName: '', //项目名
					itemExplain: '', //项目说明
				},
				financeTemplate: { //模板属性
					templateId: '', //主键
					empId: '', //员工id
					alinkeyId: '', //类别id
					templateSerial: '', //模板编号
					templateName: '', //模板名
					financeItem: []
				},
				treatmentCardRules: {
					templateName: [{
						required: true,
						message: '请输入模板名',
						trigger: 'change'
					}],
					alinkeyId: [{
						required: true,
						message: '请选择类别',
						trigger: 'change'
					}],
				}



			}
		},
		methods: {
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
			dateFormak: function(row, column) { //表格时间规格的排列
				var date = row[column.property];
			
				if (date == undefined) {
					return ''
				}
				return moment(date).format("YYYY-MM-DD hh:mm:ss")
			
			},
			Addrow() { //新增一行空表数据
				this.tableData.push({
					itemName: '',
					itemExplain: ''
				})
			},
			AddBatch() { //新增项目
				this.$confirm('是否新增?', '提示', {
					confirmButtonText: '确定',
					cancelButtonText: '取消',
					type: 'warning'
				}).then(() => {
					for (var i = 0; i < this.tableData.length; i++) {
						this.financeItem.itemName = this.tableData[i].itemName;
						this.financeItem.itemExplain = this.tableData[i].itemExplain;
						this.axios.post("/finance/addFinance", this.financeItem).then((res) => {
								console.log(res)
							if (res === "ok") {
								this.$message.success("新增成功");
								this.getQC()
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
			getFinanceItem() {
				this.axios.post("/finance/allFinance", this.financeItem).then((res) => {
					this.item = res;
				}).catch(function() {

				})
			},
			
			getKeyj(){//查询模板表
			  this.financeTemplate.templateSerial=this.input;
			  this.financeTemplate.templateName=this.input;
				this.axios.post("/template/alltemplatew", this.financeTemplate).then((res) => {
					this.getku = res;
				}).catch(function() {
				
				})
			},
			delDrugTj(row) { //添加项目数据
				this.financeTemplate.financeItem.push(row)
			},
			delDrugw(row) { //删除项目表项目

				this.financeTemplate.templateId = row.templateId;
				console.log(this.financeTemplate.templateId)
				this.$confirm('是否删除?', '提示', {
					confirmButtonText: '确定',
					cancelButtonText: '取消',
					type: 'warning'
				}).then(() => {


					this.axios.post("/template/dlltemplatew", this.financeTemplate).then((res) => {

						if (res === "ok") {
							this.$message.success("删除成功");
							this.getKeyj()
						} else {
							this.$message.error("删除失败");
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
			delDrugws(row){
				this.financeTemplate.templateId=row.templateId;
				console.log(this.financeTemplate.templateId)
				this.axios.post("/template/allmiddelw",this.financeTemplate).then((res) => {
					this.sortr = res;
					console.log(sortr)
					}).catch(function() {
					
					})
				
			},

			getClickw() { //查询类别表
				this.axios.post("/finance/allAlinkey").then((res) => {
					this.sortw = res;
				}).catch(function() {

				})
			},

			delDrug2(index) { //删除编辑

				this.financeTemplate.financeItem.splice(index, 1);
			},
			getQC() {
				for (var i = 0; i < this.financeTemplate.financeItem.length; i++) {
					this.financeTemplate.financeItem.splice(i);
				}
			},
			getTemplate() { //添加模板
				this.$confirm('是否新增?', '提示', {
					confirmButtonText: '确定',
					cancelButtonText: '取消',
					type: 'warning'
				}).then(() => {

					this.$refs['financeTemplate'].validate((valid) => {

						if (valid) {
							this.axios.post('/template/addtemplate', this.financeTemplate).then((res) => {
								if (res === "ok") {
									this.$message.success("新增成功");
									this.getQC()
									this.getKeyj()
									this.handleClose2()
								} else {
									this.$message.error("新增失败");
								}
							}).catch(function() {

							})
						} else {
							this.$message.error("请输入必填项");
							return false;
						}
					})
				}).catch(() => {
					this.$message({
						type: 'info',
						message: '已取消重置'
					});
				});
			},
			handleClose2() { //清空登记表单
				this.$refs['financeTemplate'].validate(() => {
					this.$refs['financeTemplate'].resetFields();
				})
				
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
			this.getFinanceItem()
			this.getClickw()
			this.getKeyj()

		}
	}
</script>
