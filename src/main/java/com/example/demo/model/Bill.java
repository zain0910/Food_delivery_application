package com.example.demo.model;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Bill {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer billId;
	private LocalDateTime billDate;
	private Double totalCost;
	private Integer totalItem;

	@OneToOne(cascade = CascadeType.ALL)
	private OrderDetails order;

//	public Bill(Integer billId, LocalDateTime billDate, Double totalCost, Integer totalItem, OrderDetails order) {
//		super();
//		this.billId = billId;
//		this.billDate = billDate;
//		this.totalCost = totalCost;
//		this.totalItem = totalItem;
//		this.order = order;
//	}
//
//	public Bill() {
//		super();
//	}
//
//	public Integer getBillId() {
//		return billId;
//	}
//
//	public void setBillId(Integer billId) {
//		this.billId = billId;
//	}
//
//	public LocalDateTime getBillDate() {
//		return billDate;
//	}
//
//	public void setBillDate(LocalDateTime billDate) {
//		this.billDate = billDate;
//	}
//
//	public Double getTotalCost() {
//		return totalCost;
//	}
//
//	public void setTotalCost(Double totalCost) {
//		this.totalCost = totalCost;
//	}
//
//	public Integer getTotalItem() {
//		return totalItem;
//	}
//
//	public void setTotalItem(Integer totalItem) {
//		this.totalItem = totalItem;
//	}
//
//	public OrderDetails getOrder() {
//		return order;
//	}
//
//	public void setOrder(OrderDetails order) {
//		this.order = order;
//	}
//
//	@Override
//	public String toString() {
//		return "Bill [billId=" + billId + ", billDate=" + billDate + ", totalCost=" + totalCost + ", totalItem="
//				+ totalItem + ", order=" + order + "]";
//	}

}
