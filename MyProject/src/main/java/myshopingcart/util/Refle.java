package myshopingcart.util;

import java.lang.reflect.Field;
import java.lang.reflect.ReflectPermission;

import myshopingcart.beans.Associate;

public class Refle {
	public static void main(String[] args) {
		Associate as = new Associate();
		
		as.setId(1);
		Associate as1 = new Associate();
		try {
			Class<?> cl = as1.getClass();
			Field ids1=cl.getDeclaredField("name");
			System.out.println(" old name " + as1.getName() + " is accssible : " + ids1.isAccessible() );
			ids1.setAccessible(true);
			System.out.println(" is accssible : " + ids1.isAccessible() );
			ids1.set(as1,new String("xx"));
			System.out.println(" New name " + as1.getName() );
			
			
			Object obj = cl.newInstance();
			Field ids = obj.getClass().getDeclaredField("id");
			ids.setAccessible(true);
			ids.set(obj, 3);
						
			int id1 = (int) ids.get(obj);
			System.out.println(" New Id " + id1);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	//	System.out.println(" New Id " + as1.getName() + " is accssible : " + ids1.isAccessible() );
//		System.out.println(" Field Value : " + as.getId());

	}
}
