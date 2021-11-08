<template>
    <el-table
      :data="tableData"
      style="width: 100%">
	  <el-table-column
	    prop="recruitapplyId"
	    label="申请id"
	    width="180">
	  </el-table-column>
	  <el-table-column
	    prop="recruitapplyTitle"
	    label="申请标题"
	    width="180">
	  </el-table-column>
      <el-table-column
        prop="recruitapplyEducationInf"
        label="学历要求">
      </el-table-column>
	  <el-table-column
	    prop="recruitapplyPnum"
	    label="需求人数">
	  </el-table-column>
	  <el-table-column
	    prop="recruitapplyPosition"
	    label="申请岗位">
	  </el-table-column>
	  <el-table-column
	    prop="recruitapplyEason"
	    label="申请理由">
	  </el-table-column>
	  <el-table-column
	    prop="recruitapplyTime"
	    label="申请时间">
	  </el-table-column>
	  <el-table-column
	    prop="recruitapplyState"
	    label="申请状态">
	  </el-table-column>
	  <el-table-column label="操作">
		 <template #default="scope">
			<el-button style="width: 126px;">查看</el-button><br>
			<el-button v-show="scope.row.recruitapplyState==1" @click="look(scope.row)" >发布招聘信息</el-button>
		 </template>
	  </el-table-column>
    </el-table>
	
	<el-dialog title="发布招聘信息" v-model="centerDialogVisible" width="60%">
		<div class="bod">
	<el-form ref="form" :model="form" label-width="100px">
		  
		  
			<!-- <el-form-item label="需求职位">
				<div style="width: 120px;">
					<el-input v-model="form.name"></el-input>
				</div>
			</el-form-item> -->
			<!-- <el-form-item label="发布人">
				<div style="width: 420px;">
					<el-input v-model="form.title"></el-input>
				</div>
			</el-form-item> -->
			<el-form-item label="招聘职位">
				<div style="width: 420px;">
					<el-input v-model="form.inf"></el-input>
				</div>
			</el-form-item>
			<el-form-item label="职位信息">
				<div style="width: 420px;">
					<el-input
					  type="textarea"
					  :rows="2"
					  placeholder="请输入内容"
					  v-model="form.information">
					</el-input>
				</div>
			</el-form-item>
			<el-form-item label="工作经验(年)">
				<div style="width: 420px;">
					<el-input v-model="form.workyear"></el-input>
				</div>
			</el-form-item>
	  	<el-form-item label="工作地点">
	  		<div style="width: 420px;">
	  			<el-input v-model="form.address"></el-input>
	  		</div>
	  	</el-form-item>
	  	<el-form-item label="联系电话">
	  		<div style="width: 420px;">
	  			<el-input v-model="form.tel"></el-input>
	  		</div>
	  	</el-form-item>
			<el-form-item label="薪资范围">
				<div style="width: 420px;">
					<el-input v-model="form.money"></el-input>
				</div>
			</el-form-item>
	  <el-form-item>
	    <el-button type="primary" @click="add()">发布</el-button>
	  </el-form-item>
	</el-form>
	</div>
	</el-dialog>
  </template>

<script lang="ts">
import { Timer } from '@element-plus/icons'

export default {
  data() {
    return {
	  tableData:[],
	  centerDialogVisible:false,
	  form: {
			sqid:'',
	  		inf:'',
			information:'',
	  		workyear:'',
	  		address:'',
	  		tel:'',
	  		money:''
	  },
    }
  },
  methods: {
	  look(row){
		  console.log("row",row)
		  this.centerDialogVisible=true
		  this.form.sqid=row.recruitapplyId
		  console.log("this.form.sqid",this.form.sqid)
	  },
	  add() {
		  console.log("水水水水水",this.form)
	      this.axios.post("recruitDemand/insertDemand",{
			  // rId:this.form.sqid,
	  		  demandPosition:this.form.inf,
	  		  demandAddress:this.form.address,
	  		  demandWorkyear:this.form.workyear,
	  		  demandPositionInf:this.form.information,
	  		  demandTel:this.form.tel,
	  		  demandMoney:this.form.money
	  	  }
	  	  ).then(res=>{
	      	console.log("res",res)
	      	if (res == 1) {
	      	    this.$message('成功');
	  			this.form = {}
	      	} else {
	      	    alert("新增失败");
	      	}
	      }).catch(e=>{
	      	console.log(e)
	      })
	  },
    selectAll(){
    	this.axios.post("recruitRecruitapply/selectRecruitapply").then(res=>{
    		this.tableData=res
    		console.log("tableData",this.tableData)
    	})
    }
  },created() {
	  this.selectAll()
  }
}
</script>

<style scoped="scoped">
	
</style>
  
  