const app = getApp();
const baseUrl = app.globalData.baseUrl;

export function $get(params) {
  return request(params, 'GET');
}
export function $post(params) {
  return request(params, 'POST');
}

function request(params, method) {
  let url = baseUrl + params.url;
  let data = params.data;
  return new Promise((resolve, reject) => {
    wx.request({
      url: url,
      method: method,
      data: data,
      dataType: "json",
      header: {
        'content-type': 'application/x-www-form-urlencoded',
      },
      success: (res) => {
        resolve(res);
      },
      fail: (err) => {
        reject(err);
      }
    });
  })
}