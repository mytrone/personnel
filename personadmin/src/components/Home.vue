<template>
  <el-container style="height: 730px; border: 1px solid #eee">
    <el-aside width="200px"  style="background-color: rgb(238, 241, 246)">
      
    
            <el-menu
              active-text-color="#ffd04b"
              background-color="#545c64"
              class="el-menu-vertical-demo"
              default-active="2"
              text-color="#fff"
              @open="handleOpen"
              @close="handleClose"
            >
              <el-sub-menu index="1">
                <template #title>
                  <el-icon style="margin-right: 15px"><setting /></el-icon>
                  <span>工作流程</span>
                </template>
                
                  <el-menu-item index="1-1">
					  <router-link to="flowdesign">流程设计</router-link> 
				</el-menu-item>
                  <el-menu-item index="1-2">
                  	  <router-link to="flowmonitoring">流程监控</router-link> 
                  </el-menu-item>
                <el-menu-item index="1-3">
                	  <router-link to="flowprocess">我的申请</router-link> 
                </el-menu-item>
                <el-menu-item index="1-4">
                	  <router-link to="flowagency">代办流程</router-link> 
                </el-menu-item>
				<el-menu-item index="1-5">
					  <router-link to="flowentrust">委托流程</router-link> 
				</el-menu-item>
				<el-menu-item index="1-6">
					  <router-link to="flownotice">抄送事宜</router-link> 
				</el-menu-item>
                
              </el-sub-menu>
              <el-menu-item index="2">
                <el-icon><icon-menu /></el-icon>
                <span>Navigator Two</span>
              </el-menu-item>
              <el-menu-item index="3" disabled>
                <el-icon><document /></el-icon>
                <span>Navigator Three</span>
              </el-menu-item>
              <el-menu-item index="4">
                <el-icon><setting /></el-icon>
                <span>Navigator Four</span>
              </el-menu-item>
			  <el-sub-menu index="6">
			    <template #title>
			      <el-icon style="margin-right: 15px"><setting /></el-icon>
			      <span>系统设置</span>
			    </template>			    
			      <el-menu-item index="6-1">
			  					  <router-link to="staff">用户管理</router-link> 
			  				</el-menu-item>
			      <el-menu-item index="6-2">
			      	  <router-link to="role">角色管理</router-link> 
			      </el-menu-item>
			    <el-menu-item index="6-3">
			    	  <router-link to="department">部门管理</router-link> 
			    </el-menu-item>
			    <el-menu-item index="6-4">
			    	  <router-link to="post">职位管理</router-link> 
			    </el-menu-item>			    
			  </el-sub-menu>
            </el-menu>
          
    </el-aside>

    <el-container>
      <el-header style="text-align: right; font-size: 12px">
        <el-dropdown>
          <el-icon style="margin-right: 15px"><setting /></el-icon>
          <template #dropdown>
            <el-dropdown-menu>
              <el-dropdown-item>View</el-dropdown-item>
              <el-dropdown-item>Add</el-dropdown-item>
              <el-dropdown-item>Delete</el-dropdown-item>
            </el-dropdown-menu>
          </template>
        </el-dropdown>
        <span>Tom</span>
      </el-header>

      <el-main>
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>
</template>

<script lang="ts">
import { defineComponent, ref } from 'vue'
import { Message, Menu, Setting } from '@element-plus/icons'

export default defineComponent({
  components: {
    Message,
    Setting,
    'icon-menu': Menu,
  },
  setup() {
    const item = {
      date: '2016-05-02',
      name: 'Tom',
      address: 'No. 189, Grove St, Los Angeles',
    }

    const tableData = ref(Array(20).fill(item))

    return {
      tableData,
    }
  },
})
</script>

<style>
.el-header {
  background-color: #b3c0d1;
  color: var(--el-text-color-primary);
  line-height: 60px;
}

.el-aside {
  color: var(--el-text-color-primary);
}
.el-submenu.is-opened>.el-submenu__title .el-submenu__icon-arrow {
		color: deeppink;
	}

	.el-submenu__title i {
		color: yellow;
	}

	.el-aside a {
		text-decoration: none;
		color: inherit;
		/* inherit继承 */
	}


	
</style>
