package owl.app.owlser.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import owl.app.owlser.R;
import owl.app.owlser.models.Slider;

public class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.ViewHolder>{
    private List<Slider> slider;
    private int layout;
    private OnItemSliderClickListener itemClickListener;

    private Context context;

    public SliderAdapter(List<Slider> slider, int layout, OnItemSliderClickListener listener)
    {
        this.slider = slider;
        this.layout = layout;
        this.itemClickListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        ViewHolder vh = new ViewHolder(v);
        context = parent.getContext();
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(slider.get(position), itemClickListener);
    }

    @Override
    public int getItemCount() {
        return slider.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView TextViewID;
        private TextView TextViewTitulo;
        private TextView TextViewDescripcion;
        private ImageView ImageViewPortada;

        public ViewHolder(View v)
        {
            super(v);
            TextViewID = (TextView)itemView.findViewById(R.id.cardViewID);
            TextViewTitulo = (TextView)itemView.findViewById(R.id.cardViewTitulo);
            TextViewDescripcion = (TextView)itemView.findViewById(R.id.cardViewDescripcion);
            ImageViewPortada = (ImageView)itemView.findViewById(R.id.cardViewPortada);
        }

        public void bind(final Slider slider, final OnItemSliderClickListener listener) {
            //procesamos los datos a renderizar

            String idConvertido = Integer.toString(slider.getId());

            TextViewID.setText(idConvertido);
            TextViewTitulo.setText(slider.getTitulo());
            TextViewDescripcion.setText(slider.getDescripcion());
            Picasso.with(context).load(slider.getPortada()).fit().into(ImageViewPortada);
            //Picasso.with(context).load(Api.URL_GALERIA+slider.getImagen()).fit().into(ImageViewPortada);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // ... pasamos nuestro objeto modelo (este caso String) y posición
                    listener.onItemClick(slider, getAdapterPosition());
                }
            });
        }
    }


}
