package com.alimg.blog.enums;

/**
 * 使用枚举表述常量数据字典
 */
public enum LoginStateEnum {

	SUCCESS(1, "登陆成功"), NO_USER(0, "用户名或密码错误"), ERROR_500(-1, "系统异常");

	private int state;

	private String stateInfo;

	private LoginStateEnum(int state, String stateInfo) {
		this.state = state;
		this.stateInfo = stateInfo;
	}

	public int getState() {
		return state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public static LoginStateEnum stateOf(int index) {
		for (LoginStateEnum state : values()) {
			if (state.getState() == index) {
				return state;
			}
		}
		return null;
	}

}
