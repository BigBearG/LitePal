package textitei.litepal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnCreate,mBtnInsert,mBtnDelete,mBtnQuery,mBtnUpdata;
    private TextView mTvshow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnCreate= (Button) findViewById(R.id.bt_create);
        mBtnInsert=(Button)findViewById(R.id.bt_insert);
        mBtnDelete=(Button)findViewById(R.id.bt_delete);
        mBtnQuery=(Button)findViewById(R.id.bt_select);
        mBtnUpdata=(Button)findViewById(R.id.bt_updata);
        mBtnCreate.setOnClickListener(this);
        mBtnInsert.setOnClickListener(this);
        mBtnQuery.setOnClickListener(this);
        mBtnDelete.setOnClickListener(this);
        mBtnUpdata.setOnClickListener(this);
        mTvshow= (TextView) findViewById(R.id.et_show);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_create:
                Connector.getDatabase();
                break;
            case R.id.bt_insert:
                Book book=new Book();
                book.setId(1);
                book.setAuthor("刘营海");
                book.setPrice(90);
                book.save();
                break;
            case R.id.bt_updata:
                Book book1=new Book();
                book1.setPrice(80);
                book1.updateAll("Author=?","刘营海");
                break;
            case R.id.bt_delete:
                DataSupport.deleteAll(Book.class,"Author=?","刘营海");
                break;
            case R.id.bt_select:
                List<Book> books=DataSupport.findAll(Book.class);
                for (Book book2:books){
                mTvshow.append(book2.toString());
            }

        }
    }
}
