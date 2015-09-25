package com.example.lcy0329.caculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import java.lang.String;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    private String s = "";
    private String sout = "";
//    private int numRes = 0;
    private boolean ifclean = false;
    private boolean wrongAns = false;

    private boolean isSymbol (char c)
    {
        if (c == '+' || c == '-' || c == '×' || c == '÷')
            return true;
        return false;

    }

    private void showS() {
        ifclean = false;
        int len = s.length();
        String xx = s;
        if (len > 11) {
            xx = s.substring(len - 11, len);
        }
        ((TextView)(findViewById(R.id.strIn))).setText(xx);
    }

    private void cacu() {
        wrongAns = false;
        double res = 0;
        int len = s.length();
        if (len == 0) {
            sout = "";
        } else if (isSymbol(s.charAt(len - 1))) {
            sout = "";
        } else {
            char sym = '1';
            for (int i = 0; i < len; ++i) {
                boolean decFlag = false;
                int st = i;
                if (s.charAt(i) == '-') {
                    ++i;
                    decFlag = true;
                }
                for (; i < len; ++i)
                    if (isSymbol(s.charAt(i)))
                        break;
                sout = sout + '(' + i + ')';
                sout = sout + '[' + sym + ']';
                String nums = s.substring(st, i);
                double y = Double.parseDouble(nums);
//                if (decFlag) {
//                    y = -y;
//                }
                sout = ""+y;
                if (st == 0) {
                    res = y;
                } else {
                    switch(sym) {
                        case '+': {
                            res = res + y;
                            break;
                        }
                        case '-': {
                            res = res - y;
                            break;
                        }
                        case '×': {
                            res = res * y;
                            break;
                        }
                        case '÷': {
                            res = res / y;
                            if (y == 0)
                                wrongAns = true;
                            break;
                        }
                    }
                }
                if (i != len) {
                    //记录后一个符号.
                    sym = s.charAt(i);
                }
            }
            sout ="" + res;
        }
        ((TextView) (findViewById(R.id.strRes))).setText(sout);

    }


    private void symbol(char c) {
        int len = s.length();
        if (len == 0) {
            if (c == '-')
                s += '-';
            return ;
        }
        char c2 = s.charAt(len-1);
        if (c2 != '+' && c2 != '-' && c2 != '×' && c2 != '÷') {
            s += c;
//            s = '1' + s;
            return;
        }

        //前面一个是符号情况
        if (c != '-' || (c2 != '×' && c2 != '÷')) {
            if (len > 1 && isSymbol(s.charAt(len - 2))) {
                if (c == '-') return;
                s = s.substring(0, len -2) + c;
            } else {
                s = s.substring(0, len - 1) + c;
//            s = '2' + s;
            }
            return;
        }

        //减号&前面一位是*÷情况
        s += c;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                sout = "";
                s = s + '1';
                showS();
                cacu();
            }
        });

        final Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                s = s+ '2';
                showS();
                cacu();
            }
        });

        final Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                s = s+ '3';
                showS();
                cacu();
            }
        });

        final Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                s = s+ '4';
                showS();
                cacu();
            }
        });
        final Button button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                s = s+ '5';
                showS();
                cacu();
            }
        });
        final Button button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                s = s+ '6';
                showS();
                cacu();
            }
        });
        final Button button7 = (Button) findViewById(R.id.button7);
        button7.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                s = s+ '7';
                showS();
                cacu();
            }
        });

        final Button button8 = (Button) findViewById(R.id.button8);
        button8.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                s = s+ '8';
                showS();
                cacu();
            }
        });

        final Button button9 = (Button) findViewById(R.id.button9);
        button9.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                s = s+ '9';
                showS();
                cacu();
            }
        });

        final Button button0 = (Button) findViewById(R.id.button0);
        button0.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                s = s+ '0';
                showS();
                cacu();
            }
        });

        final Button buttonP = (Button) findViewById(R.id.buttonP);
        buttonP.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                int len = s.length();
                boolean flag = true;
                for (int i = len - 1; i >= 0; --i) {
                    if (isSymbol(s.charAt(i))) break;
                    if (s.charAt(i) == '.') {
                        flag = false;
                    }
                }
                if (flag) {
                    s = s + '.';
                    showS();
                }
            }
        });

        final Button buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                symbol('+');
                showS();
                sout = "";
                ((TextView) (findViewById(R.id.strRes))).setText(sout);
            }
        });

        final Button buttonDec = (Button) findViewById(R.id.buttonDec);
        buttonDec.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                symbol('-');
                showS();
                sout = "";
                ((TextView) (findViewById(R.id.strRes))).setText(sout);
            }
        });

        final Button buttonMul = (Button) findViewById(R.id.buttonMul);
        buttonMul.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                symbol('×');
                showS();
                sout = "";
                ((TextView) (findViewById(R.id.strRes))).setText(sout);
            }
        });

        final Button buttonDiv = (Button) findViewById(R.id.buttonDiv);
        buttonDiv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                symbol('÷');
                showS();
                ((TextView) (findViewById(R.id.strRes))).setText(sout);
            }
        });

        final Button buttonEql = (Button) findViewById(R.id.buttonEql);
        buttonEql.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                cacu();
                if (!wrongAns && sout!="") {
                    s = sout;
                }
                showS();
                ((TextView) (findViewById(R.id.strRes))).setText(sout);
                ifclean = true;
            }
        });

        final Button buttonDel = (Button) findViewById(R.id.buttonDel);
        buttonDel.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ifclean) {
                    s = "";
                    sout = "";
                    ((TextView) (findViewById(R.id.strRes))).setText(sout);
                } else {
                    int len = s.length();
                    if (len > 0) {
                        s = s.substring(0, len-1);
                    }
                    --len;
                    if (len > 0)
                        if (s.charAt(len - 1) == 'E')
                            s = s.substring(0, len -1);
                    cacu();
                }
                showS();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
