package co.axacolpatria.technicaltest.customers.api.impl;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;

import java.io.IOException;

import org.osgi.service.component.annotations.Component;

import co.axacolpatria.technicaltest.customers.api.CustomersClient;
import co.axacolpatria.technicaltest.customers.model.Customers;
import okhttp3.MediaType;
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
		JSONArray customersJSONArray = JSONFactoryUtil.createJSONArray();
		
		
		try {
			OkHttpClient ohc = new OkHttpClient().newBuilder().build();
			
			Request request = new Request.Builder().url(CUSTOMERS_URL).build();
			
			Response response = ohc.newCall(request).execute();

			if(response.isSuccessful()) {
				
				String responseBody = response.body().string().replaceAll("“|”", StringPool.QUOTE);
				customersJSONArray=JSONFactoryUtil.createJSONArray(responseBody);
			}

		} catch (JSONException e) {
			LOG.error(e);
		}catch (IOException e) {
			LOG.error(e);
		}
		
		resultJSONObject.put("customers",customersJSONArray);

		return resultJSONObject;
	}

	@Override
	public JSONObject saveCustomer(Customers customer) {
		
		JSONObject resultJSONObject = JSONFactoryUtil.createJSONObject();
				
		try {
			OkHttpClient ohc = new OkHttpClient().newBuilder().build();
			
			MediaType jsonMediaType = MediaType.parse("application/json; charset=utf-8");
			
			JSONObject customerJSONObject = JSONFactoryUtil.createJSONObject();
			
			customerJSONObject.put("name", customer.getName());
			customerJSONObject.put("age", customer.getAge());
			customerJSONObject.put("phoneNumber", customer.getPhoneNumber());
			customerJSONObject.put("address", customer.getAddress());
			
			
			RequestBody body = RequestBody.create(customerJSONObject.toString(),jsonMediaType); 
					
			Request request = new Request.Builder()
					.url(CUSTOMERS_URL).method("POST", body).build();
			Response response = ohc.newCall(request).execute();
				
			resultJSONObject = JSONFactoryUtil.createJSONObject(response.body().string());
				
			} catch (IOException e) {
				LOG.error(e);
			} catch (JSONException e) {
				LOG.error(e);
			}
				
		return resultJSONObject;
	}

}
