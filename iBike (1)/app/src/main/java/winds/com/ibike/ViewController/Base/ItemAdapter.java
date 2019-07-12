package winds.com.ibike.ViewController.Base;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import winds.com.ibike.R;
import winds.com.ibike.ViewController.Model.Product;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemHolder> {

    private Context context;
    private List<Product> stringList;

    //Add a field isAll
    //private boolean isAll;

    public ItemAdapter(Context context, List<Product> stringList) {
        this.context = context;
        this.stringList = stringList;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_view_item_layout, viewGroup, false);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder itemHolder, int i) {
        Product product = stringList.get(i);
        itemHolder.tvContent1.setText(product.getContent1());
        itemHolder.tvContent2.setText(product.getContent2());
        itemHolder.tvContent3.setText(product.getContent3());
    }

    @Override
    public int getItemCount() {
        return stringList.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder {

        TextView tvContent1, tvContent2, tvContent3;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            tvContent1 = itemView.findViewById(R.id.tv_content_1);
            tvContent2 = itemView.findViewById(R.id.tv_content_2);
            tvContent3 = itemView.findViewById(R.id.tv_content_3);
        }
    }


}
