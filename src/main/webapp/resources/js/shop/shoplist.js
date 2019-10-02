$(function() {
	getlist();
	function getlist(e) {
		$.ajax({
			url : "/shopadmin/getshoplist",
			type : "get",
			dataType : "json",
			success : function(data) {
				if (data.success) {
					handleList(data.shopList);
					handleUser(data.user);
				}
			}
		});
	}
	//显示用户名
	function handleUser(data) {
		$('#user-name').text(data.name);
	}
	//显示店铺列表
	function handleList(data) {
		var html = '';
		data.map(function(item, index) {
			//逐行读取
			html += '<div class="row row-shop"><div class="col-40">'
					+ item.shopName + '</div><div class="col-40">'
					+ shopStatus(item.enableStatus)
					+ '</div><div class="col-20">'
					+ goShop(item.enableStatus, item.shopId) + '</div></div>';

		});
		//将所有信息显示到shop-wrap的div层
		$('.shop-wrap').html(html);
	}

	function shopStatus(status) {
		if (status == 0) {
			return '审核中';
		} else if (status == -1) {
			return '店铺非法';
		} else if (status == 1) {
			return '审核通过';
		}
	}
	//生成一个链接进入店铺管理
	function goShop(status, id) {
		if (status == 1) {
			return '<a href="/shopadmin/shopmanagement?shopId=' + id
					+ '">进入</a>';
		} else {
			return '';
		}
	}
});