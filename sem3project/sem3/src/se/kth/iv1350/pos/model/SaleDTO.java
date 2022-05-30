package se.kth.iv1350.pos.model;

import java.util.*;
import java.time.*;

/**
 * SaleDTO, Sale data transfer object. Grupperar variabler relaterade till en försäljning.
 */
public class SaleDTO {
	private java.time.LocalTime time;
	private String storeName = "Gurras käk";
	private double totalVAT;
	private double totalPrice;
	private List<Item> items;


	/**
	 * Skapar en instans av SaleDTO.
	 * @param time Håller den aktuella tiden för försäljningen
	 * @param storeName Innehåller namnet på butiken
	 * @param totalVAT Innehåller den totala momsen
	 * @param totalPrice Håller totalpriset
	 * @param items håller de aktuella försäljnings varorna
	 */
	public SaleDTO(java.time.LocalTime time, double totalVAT,
			double totalPrice, List<Item> items) {
		this.time = time;
		this.totalVAT = totalVAT;
		this.totalPrice = totalPrice;
		this.items = items;
	}

	/**
     * Returnerar localtime.
     * @return time returnerar localtime.
     */
	public java.time.LocalTime getTime() {
		return this.time;
	}

	/**
     * Returnerar namnet på butiken.
     * @return storeName
     */
	public String getNameOfStore() {
		return this.storeName;
	}

	/**
	 * Returnerar total moms på försäljningen
	 * @return totalVAT, innehåller den totala momsen för försäljningen
	 */
	public double getTotalVAT() {
		return this.totalVAT;
	}

	/**
	 * Returnerar den totala kostnaden
	 * @return totalPrice, innehåller totala kostanden
	 */
	public double getTotalPrice() {
		return this.totalPrice;
	}

	/**
	 * Returnerar en lista över varor i den aktuella försäljningen
	 * @return items, innehåller de aktuella varorna
	 */
	public List<Item> getItems() {
		return this.items;
	}
}
