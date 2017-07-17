package com.google.maps.android.utils.demo;

import android.content.Context;

import com.google.android.gms.maps.GoogleMap;
import com.google.maps.android.clustering.Cluster;
import com.google.maps.android.clustering.ClusterItem;
import com.google.maps.android.clustering.ClusterManager;
import com.google.maps.android.clustering.view.DefaultClusterRenderer;

public class CustomAnimationWorkingClusterRenderer<T extends ClusterItem> extends DefaultClusterRenderer<T> implements GoogleMap.OnCameraIdleListener {

    private final GoogleMap map;
    private float currentZoomLevel;

    public CustomAnimationWorkingClusterRenderer(final Context context, final GoogleMap map, final ClusterManager<T> clusterManager) {
        super(context, map, clusterManager);
        this.map = map;
    }

    @Override
    protected boolean shouldRenderAsClusterForAnimation(final Cluster<T> cluster) {
        return super.shouldRenderAsClusterForAnimation(cluster) && currentZoomLevel < 15;
    }

    @Override
    public void onCameraIdle() {
        currentZoomLevel = map.getCameraPosition().zoom;
        System.out.println("!!! currentZoomLevel: " + currentZoomLevel);
    }
}
