package com.example.belcurafaelstefanapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;


import java.util.ArrayList;

public class EconomicTermsDictionary extends AppCompatActivity {
    private RecyclerView economictermsRV;
    private ArrayList<EconomicTerms> economicTermsArrayList;
    private EconomicTermsAdapter economictermsadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_economic_terms_dictionary);
        economictermsRV = findViewById(R.id.economictermsRVid);
        buildRV();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
        MenuItem searchItem = menu.findItem(R.id.termSearch);
        SearchView searchView = (SearchView) searchItem.getActionView();
        getSupportActionBar().setTitle("Search for a term");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filter(newText);
                return false;
            }
        });
        return true;
    }

    private void filter(String text) {
        ArrayList<EconomicTerms> filteredlist = new ArrayList<>();

        for (EconomicTerms item : economicTermsArrayList) {
            if (item.geteconomicterm().toLowerCase().contains(text.toLowerCase())) {
                filteredlist.add(item);
            }
        }
        if (filteredlist.isEmpty()) {
            Toast.makeText(this, "No term with this name was found", Toast.LENGTH_SHORT).show();
        } else {
            economictermsadapter.filter(filteredlist);
        }
    }

    private void buildRV() {
        economicTermsArrayList = new ArrayList<>();
        economicTermsArrayList.add(new EconomicTerms("Amortisation", "The action or process that involves the running down or payment of a loan by instalments"));
        economicTermsArrayList.add(new EconomicTerms("Appreciation", "A rise in the value of an asset, representing the opposite of depreciation."));
        economicTermsArrayList.add(new EconomicTerms("Arbitrage", "Buying an asset in one market while simultaneously selling an identical asset in another market at a higher price."));
        economicTermsArrayList.add(new EconomicTerms("Assets", "Resources owned by a person or company that possess earning power or some other value to their owner."));
        economicTermsArrayList.add(new EconomicTerms("Barter", "The exchange (of goods or services) for other goods or services without using money, often occurring because of high inflation or counterfeiting."));
        economicTermsArrayList.add(new EconomicTerms("Bonds", "An interest-bearing security which is issued by governments, companies or other organisations."));
        economicTermsArrayList.add(new EconomicTerms("Business cycle", "Is represented by the fluctuations of gross domestic product (GDP), causing  either growth or recession."));
        economicTermsArrayList.add(new EconomicTerms("Buyer's market", "A market in which supply seems plentiful and prices seem low, representing the opposite of a seller's market."));
        economicTermsArrayList.add(new EconomicTerms("Capital", "Typically cash or liquid assets being held or obtained for expenditures."));
        economicTermsArrayList.add(new EconomicTerms("Central Bank", "A state institution that usually has the power to regulate commercial banks, create monetary policy, and provide financial services."));
        economicTermsArrayList.add(new EconomicTerms("Complementary Goods", "Items used in conjunction with another good or service that usually have little to no value when consumed alone."));
        economicTermsArrayList.add(new EconomicTerms("Compound interest ", "The addition of interest to the principal sum of a loan or deposit, the result of reinvesting interest, rather than paying it out."));
        economicTermsArrayList.add(new EconomicTerms("Credit", "The potential of a customer to obtain goods or services before payment, based on the trust that the payment will be made in the future."));
        economicTermsArrayList.add(new EconomicTerms("Debt", "An amount of money borrowed by one party from another."));
        economicTermsArrayList.add(new EconomicTerms("Demand", "An economic principle referring to a consumer's and willingness to pay a price for a specific good or service."));
        economicTermsArrayList.add(new EconomicTerms("Depression", "A sustained, long-term downturn in economic activity in one or more economies."));
        economicTermsArrayList.add(new EconomicTerms("Depreciation", "A fall in the value of an asset or a currency, the opposite of appreciation."));
        economicTermsArrayList.add(new EconomicTerms("Dividend", "A distribution of profits by a corporation to its shareholders."));
        economicTermsArrayList.add(new EconomicTerms("Elasticity", "A measure of the responsiveness of one variable to changes in another."));
        economicTermsArrayList.add(new EconomicTerms("Equilibrium", "When the Supply and the Demand are in balance."));
        economicTermsArrayList.add(new EconomicTerms("Equity", "The value that would be paid back to a company's shareholders if all of the assets were liquidated while all of the company's debts were paid off."));
        economicTermsArrayList.add(new EconomicTerms("Exchange Rate", "The value of one currency for the intention of conversion to another."));
        economicTermsArrayList.add(new EconomicTerms("Factors of production", "The resources people use to produce goods and services, considered to be represented by : land, labor, capital, and entrepreneurship."));
        economicTermsArrayList.add(new EconomicTerms("Foreign Direct Investment (FDI)", "An investment made by an individual or a firm in one country into business interests placed in another country."));
        economicTermsArrayList.add(new EconomicTerms("Game theory", "The study of mathematical models of strategic interaction among rational decision-makers."));
        economicTermsArrayList.add(new EconomicTerms("Gross domestic product (GDP)", "A monetary measure of the market value of all the final goods and services that are produced in a specific time period within a certain territory."));
        economicTermsArrayList.add(new EconomicTerms("Hedge", "Reducing some risks, involving deliberately taking on a new risk of adverse price movements in an asset, that offsets an existing one"));
        economicTermsArrayList.add(new EconomicTerms("Insurance ", "A contract, represented by a policy, in which an individual or entity receives financial protection or reimbursement against losses from an insurance company."));
        economicTermsArrayList.add(new EconomicTerms("Income", "Money that an individual or business receives in exchange for providing labor, producing a good or service, or through investing capital. "));
        economicTermsArrayList.add(new EconomicTerms("Inflation", "The decline of purchasing power of a given currency over time."));
        economicTermsArrayList.add(new EconomicTerms("Interest", "A payment from a borrower or deposit-taking financial institution to a lender or depositor of an amount above repayment of the principal sum at a particular rate."));
        economicTermsArrayList.add(new EconomicTerms("Investment", "The acquisition of an asset or item with the goal of generating income or appreciation."));
        economicTermsArrayList.add(new EconomicTerms("Liquidity", "The ease with which an asset, or security, can be converted into cash without influencing its market price. "));
        economicTermsArrayList.add(new EconomicTerms("Monetary policy", " The demand side of economic policy the actions undertaken by a nation's central bank to control money supply and achieve macroeconomic goals that promote economic growth."));
        economicTermsArrayList.add(new EconomicTerms("Nominal value", "The unadjusted rate or current price, without taking other factors e.g inflation into account as opposed to real values, where adaptations are made for general price level changes over time."));
        economicTermsArrayList.add(new EconomicTerms("Normal goods", "When theaverage Income on an individual increases, the Demand for normal goods increases as well. The opposite of Inferior Goods."));
        economicTermsArrayList.add(new EconomicTerms("Oligopoly", "A market structure with a small number of firms, none of which can keep the others from having remarkable influence."));
        economicTermsArrayList.add(new EconomicTerms("Opportunity cost", "The true cost of something is what a customer gives up in order to to obtain it."));
        economicTermsArrayList.add(new EconomicTerms("Profit", "The financial benefit realized when the revenue generated from a business activity exceeds the expenses, costs, and taxes involved in assisting that activity."));
        economicTermsArrayList.add(new EconomicTerms("Prospect theory", "A theory of 'irrational' economic behavior, on the basis of recurring partiality driven by psychological factors that influence people's choices."));
        economicTermsArrayList.add(new EconomicTerms("Purchasing Power Parity", "An economic theory that compares different countries' currencies through a 'basket of goods' point of view."));
        economicTermsArrayList.add(new EconomicTerms("Rate of return (RoR)", "The net gain or loss of an investment over a certain time period, expressed as a percentage of the investment's initial cost."));
        economicTermsArrayList.add(new EconomicTerms("Reserves", "Money in the hand, available to be used to meet planned future payments or in case other need arises."));
        economicTermsArrayList.add(new EconomicTerms("Shares ", "Units of equity ownership interest in a firm that exist as a financial asset providing for an even distribution in any residual profits, if declared, in the form of dividends."));
        economicTermsArrayList.add(new EconomicTerms("Subsidy", "A benefit given to an individual, business, or institution, usually by the government, often in the form of a cash payment or a tax reduction. "));
        economicTermsArrayList.add(new EconomicTerms("Tariff", "Tax on goods manufactured abroad, imposed by the government of the country where they are exported."));
        economicTermsArrayList.add(new EconomicTerms("Unions", "Organizations that negotiate with corporations, businesses, and other organizations representing the interests of union members."));
        economicTermsArrayList.add(new EconomicTerms("Utility", "The total satisfaction a customer receives from consuming a good or service."));
        economicTermsArrayList.add(new EconomicTerms("Value-added", "The difference between the price of a product or service and the cost of producing it."));
        economicTermsArrayList.add(new EconomicTerms("Variable cost", "A corporate expense that changes in proportion to production output."));
        economicTermsArrayList.add(new EconomicTerms("Venture capital", "A form of private equity and a type of financing that investors supply to startup companies that are considered to have long-term growth potential."));
        economicTermsArrayList.add(new EconomicTerms("Volatility", "The most widely accepted measure of risk in financial markets is the quantity by which the price of a security oscilates up and down."));
        economicTermsArrayList.add(new EconomicTerms("Wage drift", "The distinction between basic pay and total earnings, consisting of things such as overtime payments, bonuses, profit share and performance-related pay."));
        economicTermsArrayList.add(new EconomicTerms("X-Efficiency", "The degree of efficiency maintained by firms under conditions of imperfect competition."));
        economicTermsArrayList.add(new EconomicTerms("Yield", "Earnings generated on an investment over a particular period of time, computed as a percentage based on the invested amount, current market value, or face value of the security. "));
        economictermsadapter = new EconomicTermsAdapter(economicTermsArrayList, EconomicTermsDictionary.this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        economictermsRV.setHasFixedSize(true);
        economictermsRV.setLayoutManager(manager);
        economictermsRV.setAdapter(economictermsadapter);
    }
}