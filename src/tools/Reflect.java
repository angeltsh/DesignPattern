package tools;

import java.lang.reflect.Field;

import javax.swing.JLabel;

/**
 * 反射
 */
public class Reflect {
	public static void setAllComponentsName(Object f) {
		// 获取f对象对应类中的所有属性域
		Field[] fields = f.getClass().getDeclaredFields();
		for (int i = 0, len = fields.length; i < len; i++) {
			// 对于每个属性，获取属性名
			String varName = fields[i].getName();
			try {
				// 获取原来的访问控制权限
				boolean accessFlag = fields[i].isAccessible();
				// 修改访问控制权限
				fields[i].setAccessible(true);
				// 获取在对象f中属性fields[i]对应的对象中的变量
				Object o = fields[i].get(f);
				String className = fields[i].getType().getName();
				// 去掉包名
				className = className
						.substring(className.lastIndexOf(".") > 0 ? className
								.lastIndexOf(".") + 1 : 0);

				System.out.println("传入的对象中包含一个如下的变量：" + varName + " = " + o
						+ "  类型：" + className + " 访问权限" + accessFlag);
				// 恢复访问控制权限
				fields[i].setAccessible(accessFlag);
			} catch (IllegalArgumentException ex) {
				ex.printStackTrace();
			} catch (IllegalAccessException ex) {
				ex.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		// 测试代码用来获取一个JLabel中声名的所有的属性名和其属性变量
		setAllComponentsName(new JLabel("测试"));
	}
}
