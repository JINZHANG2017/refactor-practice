package com.twu.refactoring;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 * 
 */
public class OrderReceipt {
    private Order order;

    public OrderReceipt(Order o) {
        this.order = o;
	}

	public String printReceipt() {
		StringBuilder output = new StringBuilder();
		String PRINT_HEADER="======Printing Orders======\n";
		output.append(PRINT_HEADER);
        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());
		// prints lineItems
		double totSalesTx = 0d;
		double tot = 0d;
		for (LineItem lineItem : order.getLineItems()) {
			apendStringAndT(output, lineItem.getDescription());
			apendStringAndT(output, String.valueOf(lineItem.getPrice()));
			apendStringAndT(output, String.valueOf(lineItem.getQuantity()));
			output.append(lineItem.totalAmount());
			output.append('\n');

			// calculate sales tax @ rate of 10%
            double salesTax = lineItem.totalAmount() * .10;
            totSalesTx += salesTax;

            // calculate total amount of lineItem = price * quantity + 10 % sales tax
            tot += lineItem.totalAmount() + salesTax;
		}
		apendStringAndT(output, "Sales Tax");
		output.append(totSalesTx);

        // print total amount
		apendStringAndT(output, "Total Amount");
		output.append(tot);
		return output.toString();
	}

	private void apendStringAndT(StringBuilder output, String str) {
		output.append(str);
		output.append('\t');
	}
}