package com.example.belcurafaelstefanapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class Fiscality extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fiscality);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        TaxesData[] myTaxesData = new TaxesData[]{
                new TaxesData("The corporate tax"," Is a direct tax imposed by a jurisdiction on the income or capital of corporations or analogous legal entities.\n" +
                        " In Romania, the corporate tax rate that applies to the taxable profit is 16%, with the exeptions of micro-enterprises that choose to pay an income tax, if they have at least one employee that has a value of 1%, and those without any employees at the amount of 3%.\n" +
                        " The profit is computed by subtracting the Total cost ((Average fixed cost + Average variable cost) x Number of units)), from the Revenue (Sales x Average Price of Service or Sales Price).\n",R.drawable.taxesimg1),
                new TaxesData("The income tax"," Is a tax imposed on individuals or companies in respect of the income or profits earned by them. Income tax generally is computed as the product of a tax rate times the taxable income.\n" +
                        " Rather than paying a corporate tax (16%), a micro-enterprise (a company whose annual turnover does not exceed 1 million euros) can choose to pay an income tax, which has a value of 3%, if the company doesn’t have any employees, or 1% if the company has at least one employee.\n" +
                        " As an advantage, this option will minimize the tax if the firm has a high profitability (over 18.75% before tax).\n",R.drawable.taxesimg2),
                new TaxesData("The VAT"," The Value Added Tax (VAT) is a broadly based consumption tax assessed on the value added to goods and services whose payers are represented by all legal entities (companies, subsidiaries, branches), individuals and authorized family associations. \n" +
                        " The VAT rate in Romania has a value of 19% and it applies to any operation which is not exempt from VAT or which is not subject to the reduced VAT rate.\n" +
                        " Firms can request the assignment of the registration code for VAT if they declare that they will achieve a turnover that reaches or exceeds the exemption ceiling of 35,000 euros (119,000 lei) at the exchange rate on the date of accession, respectively 3.3817 lei / euro.\n",R.drawable.taxesimg3),
                new TaxesData("Local taxes"," The fee for issuing authorizations to carry out an economic activity: The economic agents owe to the local budget in whose administrative-territorial area the activity takes place, a fee for the annual issuance / endorsement of the authorization regarding the development of these activities, depending on the area related to the respective activities.\n" +
                        " The building tax: In the case of legal entities, the building tax is calculated by applying a tax rate on the inventory value of the building.\n" +
                        " Tax on the owned lands: The land tax is due to the local budget of the commune, of the city or of the municipality in which the land is located.\n",R.drawable.taxesimg4),
                new TaxesData("The Excise Duty "," Excise duties represent special consumption taxes that are due to the state budget for a series of products established by the Fiscal Code, regardless of where they originate, domestic production or imports. \n" +
                        " According to the Fiscal Code in force, in Romania, there are are paid excises for the following product categories: certain alcoholic drinks, ethyl alcohol, processed tobacco, energy products, electricity.\n",R.drawable.taxesimg5),
        };

        TaxesAdapter myTaxesAdapter = new TaxesAdapter(myTaxesData,Fiscality.this);
        recyclerView.setAdapter(myTaxesAdapter);
    }
}