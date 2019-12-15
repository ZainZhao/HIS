import Mock from 'mockjs'
import { deepClone } from '../../src/utils/index.js'
import { asyncRoutes, constantRoutes } from './routes.js'

const routes = deepClone([...constantRoutes, ...asyncRoutes])

const roles = [
  {
    key: '001',
    name: '超级管理员',
    description: '超级管理员权限',
    routes: routes
  },
  {
    key: '002',
    name: '管理员',
    description: '...',
    routes: routes.filter(i => i.path !== '/permission')// just a mock
  },
  {
    key: '003',
    name: '门诊医生',
    description: '门诊医生权限',
    routes: [{
      path: '/outpatient',
      redirect: '/outpatient/index',
      children: [
        {
          path: 'index',
          name: 'outpatient',
          meta: {
            title: '门诊医生工作台',
            icon: 'list',
            noCache: true
          },
        }
      ]
    }]
  }
]

export default [
  // mock get all routes form server
  {
    url: '/routes',
    type: 'get',
    response: _ => {
      return {
        code: 20000,
        data: routes
      }
    }
  },

  // mock get all roles form server
  {
    url: '/roles',
    type: 'get',
    response: _ => {
      return {
        code: 20000,
        data: roles
      }
    }
  },

  // add role
  {
    url: '/role',
    type: 'post',
    response: {
      code: 20000,
      data: {
        key: Mock.mock('@integer(300, 5000)')
      }
    }
  },

  // update role
  {
    url: '/role/[A-Za-z0-9]',
    type: 'put',
    response: {
      code: 20000,
      data: {
        status: 'success'
      }
    }
  },

  // delete role
  {
    url: '/role/[A-Za-z0-9]',
    type: 'delete',
    response: {
      code: 20000,
      data: {
        status: 'success'
      }
    }
  }
]
