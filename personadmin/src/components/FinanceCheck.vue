<template>
	<el-tabs v-model="activeName" @tab-click="handleClick">

		<el-tab-pane label="员工评分" name="first">
			<el-col :span="12">
				<el-button @click="drawer=true">
					查看模板
				</el-button>
			</el-col>
			<el-col :span="12">
				<el-form :model="financeCheck" ref="financeCheck" :rules="treatmentCardRules">
					<el-col :span="7" :push="1">
						<el-form-item label="员工"  prop="archivesEmpList">
							<el-select v-model="financeCheck.archivesEmpList" multiple placeholder="Select" style="width:350px;">
								<el-option v-for="item in options" :key="item.empId" :label="item.empName"
									:value="item.empId">
								</el-option>
							</el-select>
						</el-form-item>	
					</el-col>
					<el-col :span="7" :push="12">
						<el-form-item label="评语" style="width: 300px;" prop="checkRemark">
							<el-input  :rows="2" type="textarea" v-model="financeCheck.checkRemark"
							></el-input>
						</el-form-item>
					</el-col>
					<el-col :span="5" :push="19">
						<el-button @click="getFgfu()">
							确定
						</el-button>
					</el-col>
					<el-col :span="5" :push="19">
						<el-button @click="getQK()">
							清空
						</el-button>
					</el-col>
				</el-form>
			</el-col>
			<el-table :data="financeCheck.financeCheckson" style="width:100%" :header-cell-style="{'text-align':'center'}"
				:cell-style="{'text-align':'center'}">
				<el-table-column label="项目名" prop="checksonName">

				</el-table-column>
				<el-table-column label="项目评分" prop="checksonScore">

				</el-table-column>
				<el-table-column label="项目说明" prop="checksonExplain">

				</el-table-column>
				<el-table-column label="上级评分" prop="checksonPoints">
					<template v-slot:default="scope">
						<el-input-number v-model="scope.row.checksonPoints" controls-position="right" :min="1" :max="10"
							style="width: 100px">
						</el-input-number>
					</template>
				</el-table-column>
				

			</el-table>
		</el-tab-pane>
		<el-tab-pane label="查询评分" name="second">
				<el-table :data="financeCheck.financeCheckson" style="width:100%" :header-cell-style="{'text-align':'center'}"
				:cell-style="{'text-align':'center'}">
				<el-table-column label="项目名" prop="checksonName">

				</el-table-column>
				<el-table-column label="项目评分" prop="checksonScore">

				</el-table-column>
				<el-table-column label="项目说明" prop="checksonExplain">

				</el-table-column>
				<el-table-column label="上级评分" prop="checksonPoints">
					<template v-slot:default="scope">
						<el-input-number v-model="scope.row.checksonPoints" controls-position="right" :min="1" :max="10"
							style="width: 100px">
						</el-input-number>
					</template>
				</el-table-column>
				

			</el-table>
		</el-tab-pane>
		<el-drawer title="模板列表" v-model="drawer" size="60%">
			<el-col :span="7" :push="1">
				<el-input placeholder="请输入项目名查询"> </el-input>
			</el-col>
			<el-col :span="7" id="shuru1" :push="2">
				<el-row>
					<el-button type="primary" @click="getFinanceItem()">查询</el-button>
				</el-row>
			</el-col>
			<div style="height: 600px;">

				<el-table :data="item.slice((currentPage2-1)*pagesize2,currentPage2*pagesize2)" style="width:100%"
					:header-cell-style="{'text-align':'center'}" :cell-style="{'text-align':'center'}">
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
					<el-table-column label="操作">
						<template #default="scope">
							<el-button type="primary" size="medium" @click="delDrugTj(scope.row)"
								style="margin:  0  auto;">添加
							</el-button>
						</template>
					</el-table-column>
				</el-table>
				<el-pagination @size-change="handleSizeChange2" @current-change="handleCurrentChange2"
					layout="total, sizes, prev, pager, next, jumper" :page-size="pagesize2" :page-sizes="[5, 10, 15]"
					:total="item.length">
				</el-pagination>
			</div>
		</el-drawer>
	</el-tabs>
</template>

<script lang="ts">
	import {
		Timer
	} from '@element-plus/icons'
	import moment from 'moment'
	import {
		ref,
		defineComponent
	} from 'vue'
	export default {
		components: {
			Timer,
		},
		data() {
			return {
				activeName: 'first',
				query: '',
				drawer: false,
				currentPage2: 1, //职位初始页
				pagesize2: 5, //职位每页的数据
				financeCheck:{
					 checkId:'',//主键
					 // checkPoints:'',//考核总分
					 checkRemark:'',//考核评语
					 checkTemplate:'',//考核模板名
					 empId:'',
					 arcEmpId:'',
				},
				
				options:[],
				
			
				item: [],
				financeTemplate: { //模板属性
					templateId: '', //主键
					empId: '', //员工id
					alinkeyId: '', //类别id
					templateSerial: '', //模板编号
					templateName: '', //模板名

				},
				financeCheck:{
					checkId:'',//主键
					checkPoints:'',//考核总分
					checkRemark:'',//考核评语
					checkTemplate:'',//考核模板名
					financeCheckson:[],
					archivesEmpList:[]
				},
				treatmentCardRules: {
					checkRemark: [{
						required: true,
						message: '请输入评语',
						trigger: 'change'
					}],
					
				},
				
				late: [], //所属模板项目数据
				
			}
		},
		methods: {
			getQK(){
				for (var i = 0; i < this.late.length; i++) {
					this.financeCheck.financeCheckson.splice(i)
				}
			},
			delDrugTj(row) {
				this.late = row.financeItem;//接收模板表的项目数组
				this.financeCheck.checkTemplate=row.templateName;//接收模板表的名字
				
				console.log(this.late)
				for (var i = 0; i < this.late.length; i++) {
					console.log(this.late[i].itemName)
					this.financeCheck.financeCheckson.push(
					{checksonName:this.late[i].itemName,
					checksonExplain:this.late[i].itemExplain,
					checksonScore:this.late[i].itemScore,
					checksonPoints:''
					});
				}
			},
			getFgfu(){
				this.$confirm('是否新增?', '提示', {
					confirmButtonText: '确定',
					cancelButtonText: '取消',
					type: 'warning'
				}).then(() => {
				console.log(this.financeCheck)
					this.$refs['financeCheck'].validate((valid) => {
				
						if (valid) {
							this.axios.post('/chenck/addChencks', this.financeCheck).then((res) => {
								if (res === "ok") {
									this.$message.success("新增成功");
									this.getQK()
									
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
				this.$refs['financeCheck'].validate(() => {
					this.$refs['financeCheck'].resetFields();
				})
				
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
			getFinanceItem() {
				this.axios.post("/template/alltemplatesu", this.financeTemplate).then((res) => {
					this.item = res;
					console.log(this.item)
				}).catch(function() {

				})
			},
			getAawty(){
				this.axios.post("/chenck/chencks").then((res) => {
					this.options = res;
					console.log(this.options)
				}).catch(function() {
				
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

			this.getAawty()
		}
	}
</script>
