package com.app.mystore.dto;

public class ShiftSwap {

	@Override
	public String toString() {
		return "ShiftSwap [swapId=" + swapId + ", swapDate=" + swapDate + ", shiftType=" + shiftType + ", swapComments="
				+ swapComments + ", swapRequestor=" + swapRequestor + ", swapStatus=" + swapStatus + ", swappedWith="
				+ swappedWith + ", message=" + message + "]";
	}
	private int	swapId;
	private String swapDate;
	private String shiftType;
	private String swapComments;
	private String swapRequestor;  
	private String swapStatus;
	private String swappedWith;
	private String message;
	
	public int getSwapId() {
		return swapId;
	}
	public void setSwapId(int swapId) {
		this.swapId = swapId;
	}
	public String getSwapDate() {
		return swapDate;
	}
	public void setSwapDate(String swapDate) {
		this.swapDate = swapDate;
	}
	public String getShiftType() {
		return shiftType;
	}
	public void setShiftType(String shiftType) {
		this.shiftType = shiftType;
	}
	public String getSwapComments() {
		return swapComments;
	}
	public void setSwapComments(String swapComments) {
		this.swapComments = swapComments;
	}
	public String getSwapRequestor() {
		return swapRequestor;
	}
	public void setSwapRequestor(String swapRequestor) {
		this.swapRequestor = swapRequestor;
	}
	public String getSwapStatus() {
		return swapStatus;
	}
	public void setSwapStatus(String swapStatus) {
		this.swapStatus = swapStatus;
	}
	public String getSwappedWith() {
		return swappedWith;
	}
	public void setSwappedWith(String swappedWith) {
		this.swappedWith = swappedWith;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}