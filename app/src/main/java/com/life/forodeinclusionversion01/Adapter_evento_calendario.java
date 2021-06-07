package com.life.forodeinclusionversion01;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class Adapter_evento_calendario extends RecyclerView.Adapter<Adapter_evento_calendario.ViewHolder> {

    private Context mContext;
    List<evento_calendario> lista_eventos;

    public Adapter_evento_calendario(Context contexto, List<evento_calendario> lista){
        mContext = contexto;
        lista_eventos = lista;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.evento_calendario_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_evento_calendario.ViewHolder holder, int position) {
        evento_calendario currenItem = lista_eventos.get(position);
        String evento_titulo = currenItem.getTitulo();
        String evento_hora = currenItem.getHora();


        holder.titulo.setText(evento_titulo);
        holder.Hora.setText(evento_hora);
        holder.imageView.setImageResource(R.drawable.event_icon);

    }

    @Override
    public int getItemCount() {
        return lista_eventos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView imageView;
        public TextView titulo;
        public TextView Hora;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView3);
            titulo = itemView.findViewById(R.id.titulo_evento);
            Hora = itemView.findViewById(R.id.hora_evento);
        }
    }


}
