package winds.com.ibike.ViewController.Accessory;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

import winds.com.ibike.R;

public class MaterialAdapter extends RecyclerView.Adapter<MaterialAdapter.MaterialHolder> {

    private Context context;
    private List<BikeInfo> bikeInfoList;
    private boolean isAll;

    public void setBikeInfoList(List<BikeInfo> bikeInfoList) {
        this.bikeInfoList = bikeInfoList;
    }

    public MaterialAdapter(Context context, List<BikeInfo> bikeInfoList, boolean isAll) {
        this.context = context;
        this.bikeInfoList = bikeInfoList;
        this.isAll = isAll;
    }

    public MaterialHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.
                from(context).inflate(R.layout.list_view_item_layout, viewGroup, false);
        return new MaterialHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MaterialHolder materialHolder, int i) {
        BikeInfo bikeInfo = bikeInfoList.get(i);
        materialHolder.ivNext.setVisibility(View.GONE);
        if(isAll)
        {
            materialHolder.materialName.setText(bikeInfo.getMaterialName());
            materialHolder.price.setText(bikeInfo.getPrice() + "");
            materialHolder.maxKm.setVisibility(View.GONE);
        }else {
            materialHolder.materialName.setText(bikeInfo.getMaterialName());
            materialHolder.price.setText(bikeInfo.getPrice() + "");
            materialHolder.maxKm.setText(bikeInfo.getMaxKm() + "");
        }
    }

    @Override
    public int getItemCount() {
        return bikeInfoList.size();
    }

    public class MaterialHolder extends RecyclerView.ViewHolder {

        TextView materialName, price, maxKm;
        ImageView ivNext;

        public MaterialHolder(@NonNull View itemView) {
            super(itemView);
            materialName = itemView.findViewById(R.id.tv_content_1);
            price = itemView.findViewById(R.id.tv_content_3);
            maxKm = itemView.findViewById(R.id.tv_content_2);
            ivNext = itemView.findViewById(R.id.iv_next);
        }
    }
}
