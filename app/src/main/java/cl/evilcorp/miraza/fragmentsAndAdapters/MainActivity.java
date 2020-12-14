package cl.evilcorp.miraza.fragmentsAndAdapters;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import cl.evilcorp.miraza.R;
import cl.evilcorp.miraza.databinding.ActivityMainBinding;
import cl.evilcorp.miraza.model.BreedModel;
import cl.evilcorp.miraza.presenter.BreedPresenter;
import cl.evilcorp.miraza.presenter.IBreedPresenter;

public class MainActivity extends AppCompatActivity implements IBreedPresenter, OnItemClickListener {
    private ActivityMainBinding binding;
    private BreedPresenter presenter;
    private BreedAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        View view =binding.getRoot();
        setContentView(view);
        adapter=new BreedAdapter(new ArrayList<>(),this);
        presenter=new BreedPresenter(this,new BreedModel());
        RecyclerView recyclerView=binding.rvBreed;
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onClick(int position) {
      getSupportFragmentManager().beginTransaction().replace(R.id.fr_recicler, ImageFragment.newInstance("",adapter.getBreedList().get(position))).addToBackStack("Detalle").commit();
    }

    @Override
    public void showBreed(List<String> breeds) {
    adapter.UpdateBreed(breeds);
    }

}