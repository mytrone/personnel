<template>
    <el-table
      :data="tableData"
      style="width: 100%">
	  <el-table-column
	    prop="lookjlName"
	    label="姓名"
	    width="180">
	  </el-table-column>
      <el-table-column
        prop="lookjlStudy"
        label="学历">
      </el-table-column>
	  <el-table-column label="操作">
		 <template #default="scope">
			<el-button @click="this.centerDialogVisible=true,hang(scope.row)">发送面试邀请</el-button><br>
		 </template>
	  </el-table-column>
    </el-table>
	
	<el-dialog title="发布招聘信息" v-model="centerDialogVisible" width="60%">
	<el-form ref="form" :model="form" label-width="100px">
		<el-form-item label="通知人">
				<div style="width: 420px;">
					<el-input v-model="form.name">{{form.name}}</el-input>
				</div>
		</el-form-item>
		
		<el-form-item label="面试时间">
				<div style="width: 420px;">
					 <el-date-picker
					       v-model="form.intime"
					       type="datetime"
					       placeholder="选择日期时间">
					     </el-date-picker>
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
		
	  <el-form-item>
	    <el-button type="primary" @click="add()">通知</el-button>
	  </el-form-item>
	  
	</el-form>
	</el-dialog>
	<el-dialog title="面试打分" v-model="centerDialogVisible2" width="60%">
		<el-form ref="faft" :model="faft" label-width="100px">
		  	<el-form-item label="面试得分">
		  		<div style="width: 420px;">
		  			<el-input v-model="faft.numb"></el-input>
		  		</div>
		  	</el-form-item>
			
		  <el-form-item>
		    <el-button type="primary" @click="dafen()">打分</el-button>
		  </el-form-item>
		  
		</el-form>
	</el-dialog>
	
  </template>
	
<script lang="ts">
import { Timer } from '@element-plus/icons'

export default {
  data() {
    return {
		 pickerOptions: {
		          shortcuts: [{
		            text: '今天',
		            onClick(picker) {
		              picker.$emit('pick', new Date());
		            }
		          }, {
		            text: '昨天',
		            onClick(picker) {
		              const date = new Date();
		              date.setTime(date.getTime() - 3600 * 1000 * 24);
		              picker.$emit('pick', date);
		            }
		          }, {
		            text: '一周前',
		            onClick(picker) {
		              const date = new Date();
		              date.setTime(date.getTime() - 3600 * 1000 * 24 * 7);
		              picker.$emit('pick', date);
		            }
		          }]
		        },
	  tableData:[],
	  centerDialogVisible:false,
	  centerDialogVisible2:false,
	  form:{
		  name:'',
		  intime:'',
		  address:'',
		  tel:''
	  },
	  faft:{
		  msr:'',
		  ttim:'',
		  numb:0
	  }
    }
  },
  methods: {
	  dafen(){
		  this.axios.post("recruitinterviewrecord/insertInterviewrecord",{
		  	  		  interviewrecordName:this.faft.msr,
		  	  		  interviewrecordNumber:this.faft.numb
		  }).then(res=>{
		  	if (res == 1) {
		  		this.faft={}
		  		this.centerDialogVisible2=false
		  	} else {
		  	    alert("新增失败");
		  	}
	  })
	  },
	 hang(row){
		 console.log("row",row)
		 this.form.name=row.lookjlName
		 this.faft.msr=row.lookjlName
	 },
	add(){
		this.axios.post("recruitInterviewnotice/insertInterviewnotice",{
			  		  interviewnoticeName:this.form.name,
			  		  interviewnoticeIntime:this.form.intime,
			  		  interviewnoticeDidian:this.form.address,
			  		  interviewnoticeTel:this.form.tel
		}).then(res=>{
			console.log("res",res)
			if (res == 1) {
			    alert("新增成功");
				this.form={}
				this.centerDialogVisible=false
				this.centerDialogVisible2=true
			} else {
			    alert("新增失败");
			}
		}).catch(e=>{
			console.log(e)
		})
	},
    selectAll(){
    	this.axios.post("recruitLookjl/selectRecruitLookjl").then(res=>{
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
  
  