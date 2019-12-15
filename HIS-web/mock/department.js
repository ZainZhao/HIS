import Mock from 'mockjs'

const List = []
const count = 100

for (let i = 0; i < count; i++) {
  List.push(Mock.mock({
    id: '@increment',
    code: '@increment',
    catId: '@integer(11,29)',
    'name|1': ['心血管内科','神经内科','消化内科','药剂科'],
    type: '@integer(1,4)'
  }))
}

export default [
  {
    url: '/deplist',
    type: 'get',
    response: _ => {
      return {
        code: 20000,
        data: List
      }
    }
  },
  {
    url: '/dep/list',
    type: 'get',
    response: config => {
      const { code,catId,name,type,page = 1, limit = 20 } = config.query
      let mockList = List.filter(item => {
        if (code && item.code !== +code) return false
        if (catId && item.catId !== +catId) return false
        if (type && item.type !== +type) return false
        if (name && item.name !== name) return false
        return true
      })
      const pageList = mockList.filter((item, index) => index < limit * page && index >= limit * (page - 1))
      return {
        code: 20000,
        data: {
          total: mockList.length,
          items: pageList
        }
      }
    }
  }
]