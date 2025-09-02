import { createRouter, createWebHistory } from 'vue-router'
import Home from '../components/Home.vue'
import EmpresaPage from '../components/EmpresaPage.vue'

const routes = [
  { path: '/', component: Home },
  { path: '/empresa/:id', component: EmpresaPage, props: true }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
