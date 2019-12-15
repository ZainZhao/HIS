import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

const store = new Vuex.Store({
	state: {
		// url: 'localhost:9999',
		url: '10.25.52.152:10021/app',
		hasLogin: false,
		name: '',
		patientId: '',
		idCard: '',
		homeAddress: '',
		phoneNo: '',
		gender: '',
		medicalRecordNo: '',
		dateOfBirth: ''
	},
	mutations: {
		login(state, provider) {
			state.hasLogin = true;
			state.name = provider.name;
			state.patientId = provider.id;
			state.idCard = provider.identificationNo;
			state.homeAddress = provider.homeAddress;
			state.phoneNo = provider.phoneNo;
			state.medicalRecordNo = provider.medicalRecordNo;
			state.dateOfBirth = provider.dateOfBirth;
			if(provider.gender == 0){
				state.gender = '男';
			}else if(provider.gender == 1){
				state.gender = '女';
			}
		},
		logout(state) {
			state.hasLogin = false;
			name = '';
			patientId: '';
			idCard: '';
			homeAddress: '';
			phoneNo: '';
			gender: '';
			medicalRecordNo: ''
		}
	},
	actions: {
		// lazy loading openid
		getUserOpenId: async function ({
			commit,
			state
		}) {
			return await new Promise((resolve, reject) => {
				if (state.openid) {
					resolve(state.openid)
				} else {
					uni.login({
						success: (data) => {
							commit('login')
							setTimeout(function () { //模拟异步请求服务器获取 openid
								const openid = '123456789'
								console.log('uni.request mock openid[' + openid + ']');
								commit('setOpenid', openid)
								resolve(openid)
							}, 1000)
						},
						fail: (err) => {
							console.log('uni.login 接口调用失败，将无法正常使用开放接口等服务', err)
							reject(err)
						}
					})
				}
			})
		}
	}
})

export default store
