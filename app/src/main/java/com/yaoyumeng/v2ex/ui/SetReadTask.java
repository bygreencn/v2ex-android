package com.yaoyumeng.v2ex.ui;

import android.os.AsyncTask;
import android.widget.BaseAdapter;

import com.yaoyumeng.v2ex.Application;
import com.yaoyumeng.v2ex.database.V2EXDataSource;
import com.yaoyumeng.v2ex.model.TopicModel;

/**
 * Created by yw on 2015/5/13.
 */
public class SetReadTask extends AsyncTask<TopicModel, Integer, Boolean> {
    private TopicModel mTopicModel;
    private BaseAdapter mAdapter;
    private V2EXDataSource mDataSource = Application.getDataSource();

    public SetReadTask(TopicModel topic, BaseAdapter adapter) {
        mTopicModel = topic;
        mAdapter = adapter;
    }

    @Override
    protected void onPreExecute() {
    }

    @Override
    protected Boolean doInBackground(TopicModel... params) {
        return mDataSource.readTopic(mTopicModel);
    }

    @Override
    protected void onProgressUpdate(Integer... progresses) {
    }

    @Override
    protected void onPostExecute(Boolean result) {
        mAdapter.notifyDataSetChanged();
    }
}