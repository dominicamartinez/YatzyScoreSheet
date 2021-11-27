package com.slifer.yatzyscoresheet;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText one1, one2, one3;
    EditText two1, two2, two3;
    EditText three1, three2, three3;
    EditText four1, four2, four3;
    EditText five1, five2, five3;
    EditText six1, six2, six3;
    EditText bonus1, bonus2, bonus3;
    EditText threeOfAKind1, threeOfAKind2, threeOfAKind3;
    EditText fourOfAKind1,fourOfAKind2, fourOfAKind3;
    EditText smStraight1, smStraight2, smStraight3;
    EditText lgStraight1, lgStraight2, lgStraight3;
    EditText fullHouse1, fullHouse2, fullHouse3;
    EditText yahtzy1, yahtzy2, yahtzy3;
    EditText chance1, chance2, chance3;
    EditText[] column1, column2, column3;
    boolean darkMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        one1 = (EditText)findViewById(R.id.one1);
        two1 = (EditText)findViewById(R.id.two1);
        three1 = (EditText)findViewById(R.id.three1);
        four1 = (EditText)findViewById(R.id.four1);
        five1 = (EditText)findViewById(R.id.five1);
        six1 = (EditText)findViewById(R.id.six1);
        one2 = (EditText)findViewById(R.id.one2);
        two2 = (EditText)findViewById(R.id.two2);
        three2 = (EditText)findViewById(R.id.three2);
        four2 = (EditText)findViewById(R.id.four2);
        five2 = (EditText)findViewById(R.id.five2);
        six2 = (EditText)findViewById(R.id.six2);
        one3 = (EditText)findViewById(R.id.one3);
        two3 = (EditText)findViewById(R.id.two3);
        three3 = (EditText)findViewById(R.id.three3);
        four3 = (EditText)findViewById(R.id.four3);
        five3 = (EditText)findViewById(R.id.five3);
        six3 = (EditText)findViewById(R.id.six3);
        bonus1 = (EditText)findViewById(R.id.bonus1);
        threeOfAKind1 = (EditText)findViewById(R.id.threeOfAKind1);
        fourOfAKind1 = (EditText)findViewById(R.id.fourOfAKind1);
        smStraight1 = (EditText)findViewById(R.id.smStraight1);
        lgStraight1 = (EditText)findViewById(R.id.lgStraight1);
        fullHouse1 = (EditText)findViewById(R.id.fullHouse1);
        yahtzy1 = (EditText)findViewById(R.id.yahtzy1);
        chance1 = (EditText)findViewById(R.id.chance1);
        bonus2 = (EditText)findViewById(R.id.bonus2);
        threeOfAKind2 = (EditText)findViewById(R.id.threeOfAKind2);
        fourOfAKind2 = (EditText)findViewById(R.id.fourOfAKind2);
        smStraight2 = (EditText)findViewById(R.id.smStraight2);
        lgStraight2 = (EditText)findViewById(R.id.lgStraight2);
        fullHouse2 = (EditText)findViewById(R.id.fullHouse2);
        yahtzy2 = (EditText)findViewById(R.id.yahtzy2);
        chance2 = (EditText)findViewById(R.id.chance2);
        bonus3 = (EditText)findViewById(R.id.bonus3);
        threeOfAKind3 = (EditText)findViewById(R.id.threeOfAKind3);
        fourOfAKind3 = (EditText)findViewById(R.id.fourOfAKind3);
        smStraight3 = (EditText)findViewById(R.id.smStraight3);
        lgStraight3 = (EditText)findViewById(R.id.lgStraight3);
        fullHouse3 = (EditText)findViewById(R.id.fullHouse3);
        yahtzy3 = (EditText)findViewById(R.id.yahtzy3);
        chance3 = (EditText)findViewById(R.id.chance3);

        column1 = new EditText[]{one1, two1, three1, four1, five1, six1, bonus1, threeOfAKind1,
                fourOfAKind1, fullHouse1, smStraight1, lgStraight1, yahtzy1, chance1};
        column2 = new EditText[]{one2, two2, three2, four2, five2, six2, bonus2, threeOfAKind2,
                fourOfAKind2, fullHouse2, smStraight2, lgStraight2, yahtzy2, chance2};
        column3 = new EditText[]{one3, two3, three3, four3, five3, six3, bonus3, threeOfAKind3,
                fourOfAKind3, fullHouse3, smStraight3, lgStraight3, yahtzy3, chance3};

        for (int i = 0; i < 6; i++) {
            column1[i].addTextChangedListener(new ColumnWatcher(1));
            column2[i].addTextChangedListener(new ColumnWatcher(2));
            column3[i].addTextChangedListener(new ColumnWatcher(3));
        }

        darkMode = false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Toast.makeText(this, "Selected Item: " +item.getTitle(), Toast.LENGTH_SHORT).show();
        switch (item.getItemId()) {
            case R.id.new_game_item:
                for (int i = 0; i < column1.length; i++) {
                    column1[i].setText("");
                    column2[i].setText("");
                    column3[i].setText("");
                }
                return true;
            case R.id.toggle_light_dark_item:
                toggleDarkMode();
                return true;
            case R.id.about_item:
                Toast.makeText(this, "Written by: Dominic Martinez", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void calcScoreClick(View view) {
        TextView scoreTextView = (TextView) findViewById(R.id.textView16);

        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;
        for (int i = 0; i < column1.length; i++) {
            sum1 += Integer.parseInt(column1[i].getText().toString().equals("") ? "0" : column1[i].getText().toString());
            sum2 += Integer.parseInt(column2[i].getText().toString().equals("") ? "0" : column2[i].getText().toString());
            sum3 += Integer.parseInt(column3[i].getText().toString().equals("") ? "0" : column3[i].getText().toString());
        }

        scoreTextView.setText(String.valueOf(sum1 + (2*sum2) + (3*sum3)));
    }

    private void bonusCalc(int col) {
        int tempSum = 0;
        for (int i = 0; i < 6; i++) {
            if (col == 1) tempSum += Integer.parseInt(column1[i].getText().toString().equals("") ? "0" : column1[i].getText().toString());
            if (col == 2) tempSum += Integer.parseInt(column2[i].getText().toString().equals("") ? "0" : column2[i].getText().toString());
            if (col == 3) tempSum += Integer.parseInt(column3[i].getText().toString().equals("") ? "0" : column3[i].getText().toString());
        }
        if (tempSum > 62 && col == 1) bonus1.setText("35");
        if (tempSum < 63 && col == 1) bonus1.setText("");
        if (tempSum > 62 && col == 2) bonus2.setText("35");
        if (tempSum < 63 && col == 2) bonus2.setText("");
        if (tempSum > 62 && col == 3) bonus3.setText("35");
        if (tempSum < 63 && col == 3) bonus3.setText("");
    }

    private void toggleDarkMode() {
        if (!darkMode) { // turn on dark mode
            findViewById(R.id.myScrollView).setBackgroundColor(Color.BLACK);
            findViewById(R.id.myRelativeLayout).setBackgroundColor(Color.BLACK);
            ViewGroup root = findViewById(R.id.myRelativeLayout);
            findTextViewsforDarkMode(root);
            darkMode = true;
        }
        else {
            findViewById(R.id.myScrollView).setBackgroundColor(Color.WHITE);
            findViewById(R.id.myRelativeLayout).setBackgroundColor(Color.WHITE);
            ViewGroup root = findViewById(R.id.myRelativeLayout);
            findTextViewsforDarkMode(root);
            darkMode = false;
        }
    }

    private void findTextViewsforDarkMode(ViewGroup root) {
        for (int i = 0; i < root.getChildCount(); i++) {
            View child = root.getChildAt(i);

            if (child instanceof EditText) {
            }
            else if (child instanceof TextView) {
                if (!darkMode) { // turning on dark mode
                    ((TextView) child).setTextColor(Color.GRAY);
                }
                else {
                    ((TextView) child).setTextColor(Color.BLACK);
                }
                //mTextViews.add(child);
            } else if (child instanceof ViewGroup) {
                findTextViewsforDarkMode((ViewGroup) child);
            }
        }
    }

    class ColumnWatcher implements TextWatcher {
        int col;

        ColumnWatcher(int col) {
            super();
            this.col = col;
        }

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }
        @Override
        public void afterTextChanged(Editable s) {
            bonusCalc(col);
        }
    }
}

