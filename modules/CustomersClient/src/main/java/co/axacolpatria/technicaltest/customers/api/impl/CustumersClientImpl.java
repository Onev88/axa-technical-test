package co.axacolpatria.technicaltest.customers.api.impl;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import co.axacolpatria.technicaltest.customers.api.CustomersClient;
import co.axacolpatria.technicaltest.customers.model.Customers;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Component
public class CustumersClientImpl implements CustomersClient {

	private static final String CUSTOMERS_URL = PropsUtil.get("co.axacolpatria.technicaltest.customers.url");
	
	private static final Log LOG = LogFactoryUtil.getLog(CustumersClientImpl.class);

	@Override
	public JSONObject getCustomers() {
		// TODO Auto-generated method stub
		
		JSONObject resultJSONObject = JSONFactoryUtil.createJSONObject();
		
		try {
			OkHttpClient ohc = new OkHttpClient().newBuilder().build();

			RequestBody body = new MultipartBody.Builder().build();

			Request request = new Request.Builder().url(CUSTOMERS_URL + "/customers").build();
			Response response = ohc.newCall(request).execute();

			if(response.isSuccessful()) {
				resultJSONObject.put("customers",response.body().string());
			}

		}catch (IOException e) {
			LOG.error(e);
		}

		return resultJSONObject;
	}

	@Override
	public JSONObject saveCustomer(Customers customer) {
		JSONObject resultJSONObject = JSONFactoryUtil.createJSONObject();
		List<Customers> customersList = new ArrayList<Customers>();
		
		try {
			OkHttpClient ohc = new OkHttpClient().newBuilder().build();

			RequestBody body = new MultipartBody.Builder().build();

			Request request = new Request.Builder().url(CUSTOMERS_URL + "/customers").method("POST", body).build();
			Response response = ohc.newCall(request).execute();

			if(response.isSuccessful()) {
				resultJSONObject.put("customers",response.body().string());
			}

		}catch (IOException e) {
			LOG.error(e);
		}

		return resultJSONObject;
	}

}
