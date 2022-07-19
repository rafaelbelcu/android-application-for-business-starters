package com.example.belcurafaelstefanapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class BusinessDevelopment extends AppCompatActivity {
    RecyclerView recyclerView;
    List<BusinessDevelopmentClass> businessDevList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_development);
        recyclerView= findViewById(R.id.businessRV);
        initializeData();
        setRecyclerView();

        Button btn1 = findViewById(R.id.button1);
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myWebLink1 = new Intent(android.content.Intent.ACTION_VIEW);
                myWebLink1.setData(Uri.parse("https://mfinante.gov.ro/domenii/ajutorstat"));
                startActivity(myWebLink1);
            }
        });

        Button btn2 = findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myWebLink2 = new Intent(android.content.Intent.ACTION_VIEW);
                myWebLink2.setData(Uri.parse("https://www.mdlpa.ro/"));
                startActivity(myWebLink2);
            }
        });

        Button btn3 = findViewById(R.id.button3);
        btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myWebLink3 = new Intent(android.content.Intent.ACTION_VIEW);
                myWebLink3.setData(Uri.parse("https://edirect.e-guvernare.ro/SitePages/landingpage.aspx"));
                startActivity(myWebLink3);
            }
        });
    }

    private void setRecyclerView() {
        BusinessDevelopmentAdapter businessDevAdapter = new BusinessDevelopmentAdapter(businessDevList);
        recyclerView.setAdapter(businessDevAdapter);
        recyclerView.setHasFixedSize(true);
    }

    private void initializeData() {
        businessDevList = new ArrayList<>();
        businessDevList.add(new BusinessDevelopmentClass("Legal forms of business", "  Limited Liability Company (S.R.L.) it is a legal form of business where a certain category of a legal person has a limited liability under the law and towards its owners.\n" +
                "  General Partnership (S.N.C.) is a business agreement by which two or more entities agree to share all the profits, assets, and financial as well as legal liabilities of a jointly-owned business.\n" +
                "  Limited Partnership (S.C.S.) represents an organization consisting of a general partner, who manages the company, having unlimited personal liability for the debts and and duties of the business, and a limited partner, who has limited liability but cannot be a participant in the administration of the firm.\n" +
                "  Joint Stock Company (S.A.) consists in a business owned by its investors, with each one of them being in possession of a share based on the amount of stock invested and its minimum capital cannot be less than EUR 25,000.\n" +
                "  Sole Trader (Freelancer): A sole partnership can be established by Romanian/certain EU Member States citizens who have professional training in the domain they want to be licensed in.\n"));
        businessDevList.add(new BusinessDevelopmentClass("Aid for companies", "  When it comes to establishing a new businesses, the support given to the entrepreneurs may be:\n" +
                "  Indirect: from the state budget (through national financing programmes), structural funds (non-reimbursable financing), bank guarantees or microfinancing (loans).\n" +
                "  Direct: through operational programs managed by the Ministry of Public Works, Development and Administration.\n" +
                "  Access to European funds: small and medium-sized enterprises can apply for grants, loans and guarantees through the Ministry of European Funds. They may also try to earn contracts for the supply of goods or services.\n" +
                "  Private funding: through banks, the private sector provides a variety of financing options depending on the type of the company.\n"));
        businessDevList.add(new BusinessDevelopmentClass("Business partnerships "," Partnerships constitute a major part in terms of successful companies, and can be classified by their type as:\n" +
                "  Partnership – the association two or more individuals with prospects to conducting non-corporate business.\n" +
                "  Joint venture – the commercial enterprise initiated jointly by two or more parties that otherwise would maintain their distinct identities.\n" +
                "  Merger – two separate businesses blending in order to become one entity or one business, taking over the other. \n" +
                "  Establishing mixed companies – firms that have a share capital consisting of domestic as well as foreign shareholders.\n"));
        businessDevList.add(new BusinessDevelopmentClass("Recruitment","  There are certain initiatives that are used to stimulate business-owners in hiring new employees and  subsequently creating new jobs. \n" +
                "  Employers may be eligible to receive subsidies in order to create new jobs when it comes to the following cases: employing graduates or jobless people over the age of 45, jobless people who are the sole caregivers in single parent families or have three years left until retirement, along with people with disabilities. In the previously-mentioned categories, employers are exempt from the payment of particular contributions and they can also be granted loans on beneficial terms.\n"));
        businessDevList.add(new BusinessDevelopmentClass("Labor Code","  The Labour Code represents the most important regulatory act regarding the ruling of the employment relationships and the business-owners must consider their employment relationship with the employees in conformity with the laws in force. \n" +
                "  Accordingly, it is essential as a business owner to research all the provisions existent in the Code.\n"));
        businessDevList.add(new BusinessDevelopmentClass("Employment contracts","  The individual employment contract represents the agreement in conformity with the fact that a natural person, specifically an employee, manages to provide work for and under the administration of an employer, specifically a natural person or legal entity, in return for payment, specifically a wage, conditioned by the provisions of the Labour Code.\n" +
                "  The structural model of the individual employment contract can be found on the edirect.e-guvernare.ro website.\n"));
    }


}