package mad9132.planets;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import mad9132.planets.model.PlanetPOJO;

/**
 * Class PlanetAdapter.
 *
 * {@link PlanetAdapter} exposes a list of planets to a
 * {@link android.support.v7.widget.RecyclerView}
 */

public class PlanetAdapter extends RecyclerView.Adapter<PlanetAdapter.ViewHolder> {

    private Context mContext;
    private List<PlanetPOJO> mPlanets;

    public PlanetAdapter(Context context, List<PlanetPOJO> planets) {
        this.mContext = context;
        this.mPlanets = planets;
    }

    /**
     * This gets called when each new ViewHolder is created. This happens when the RecyclerView
     * is laid out. Enough ViewHolders will be created to fill the screen and allow for scrolling.
     *
     * @param parent    The parent ViewGroup that these ViewHolders are contained within.
     * @param viewType  If your RecyclerView has more than one type of item (which ours doesn't) you
     *                  can use this viewType integer to provide a different layout. See
     *                  {@link android.support.v7.widget.RecyclerView.Adapter#getItemViewType(int)}
     *                  for more details.
     * @return A new PlanetAdapterViewHolder that holds the View for each list item
     */
    @Override
    public PlanetAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View planetView = inflater.inflate(R.layout.list_planet, parent, false);
        ViewHolder viewHolder = new ViewHolder(planetView);
        return viewHolder;
    }

    /**
     * OnBindViewHolder is called by the RecyclerView to display the data at the specified
     * position. In this method, we update the contents of the ViewHolder to display the planet
     * details for this particular position, using the "position" argument that is conveniently
     * passed into us.
     *
     * @param holder The ViewHolder which should be updated to represent the
     *               contents of the item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(PlanetAdapter.ViewHolder holder, int position) {
        final PlanetPOJO planet = mPlanets.get(position);

        holder.tvName.setText(planet.getName());

        holder.mView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(mContext, "You long clicked " + planet.getName(),
                        Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    /**
     * This method simply returns the number of planets to display. It is used behind the scenes
     * to help layout our Views and for animations.
     *
     * @return The number of planets
     */
    @Override
    public int getItemCount() {
        return mPlanets.size();
    }

    /**
     * Recycle the children views for a planet list item.
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvName;
        public View mView;

        public ViewHolder(View planetView) {
            super(planetView);

            tvName = (TextView) planetView.findViewById(R.id.planetNameText);
            mView = planetView;
        }
    }
}
