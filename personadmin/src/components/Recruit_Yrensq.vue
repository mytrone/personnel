<template>	
	<h3>用人申请单</h3>
	<div class="bod">
  <el-form ref="form" :model="form" label-width="100px">
	<el-row>
		<!-- <el-form-item label="申请人">
			<div style="width: 120px;">
				<el-input v-model="form.name"></el-input>
			</div>
		</el-form-item> -->
		<el-form-item label="申请标题">
			<div style="width: 100px;">
				<el-input v-model="form.title"></el-input>
			</div>
		</el-form-item>
		<el-form-item label="需求岗位">
			<div style="width: 100px;">
				<el-input v-model="form.position"></el-input>
			</div>
		</el-form-item>
		<el-form-item label="需求人数">
			<div style="width: 190px;">
				<el-input v-model="form.num"></el-input>
			</div>
		</el-form-item>
	</el-row>
    <el-row>
    	<el-form-item label="学历信息">
    		<div style="width: 420px;">
    			<el-input v-model="form.xueli"></el-input>
    		</div>
    	</el-form-item>
		
    	<el-form-item label="理由">
    		<div style="width: 290px;">
    			<el-input v-model="form.eason"></el-input>
    		</div>
    	</el-form-item>
		
	
		
    </el-row>
    <el-form-item>
      <el-button type="primary" @click="add()">提交</el-button>
    </el-form-item>
  </el-form>
  </div>
</template>

<script lang="ts">
import { Timer } from '@element-plus/icons'

export default {
  data() {
    return {
	  dname:'',
	  tableData:[],
      form: {
        title:'',
		position:'',
		num:'',
		xueli:'',
		eason:''
      },
    }
  },
  methods: {
	  
	 
	  
    add() {
		console.log("水水水水水",this.form)
      this.axios.post("recruitRecruitapply/insertRecruitapply",{
		  recruitapplyTitle:this.form.title,
		  recruitapplyPosition:this.form.position,
		  recruitapplyPnum:this.form.num,
		  recruitapplyEducationInf:this.form.xueli,
		  recruitapplyEason:this.form.eason
	  }
	  ).then(res=>{
      	console.log("res",res)
		console.log("res",res2)
      	if (res.data == 1) {
      	    alert("新增成功");
      	} else {
      	    alert("新增失败");
      	}
      }).catch(e=>{
      	console.log(e)
      })
  },created() {
	  
  }
},
}
</script>
<style>
	.bod{
		width: 50%;
	}
	body{text-align:center} 
</style>