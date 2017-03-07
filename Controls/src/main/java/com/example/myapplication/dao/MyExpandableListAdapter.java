package com.example.myapplication.dao;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/26.
 */

public class MyExpandableListAdapter extends BaseExpandableListAdapter {
    Context context;//上下文
    LayoutInflater inflater;//声明一个布局管理器对象
    Map<String, Object> map;//声明一个map对象
    List<Map<String, Object>> group;//声明一个组集合
    List<List<Map<String, Object>>> child;//声明一个子元素集合

    public MyExpandableListAdapter(Context context, List<Map<String, Object>> group, List<List<Map<String, Object>>> child) {
        this.context = context;//初始化上下文
        inflater = LayoutInflater.from(context);//初始化布局管理器对象
        this.group = group;//初始化组集合
        this.child = child;//初始化子元素集合
    }

    /**
     * 获取组长
     *
     * @return
     */
    @Override
    public int getGroupCount() {
        return group.size();
    }

    /**
     * 获取指定组中子元素的个数
     *
     * @param groupPosition
     * @return
     */
    @Override
    public int getChildrenCount(int groupPosition) {
        return child.get(groupPosition).size();
    }

    /**
     * 得到指定组的组数据
     *
     * @param groupPosition:指定的组的位置
     * @return返回指定组的组数据
     */
    @Override
    public Object getGroup(int groupPosition) {
//        group.get(groupPosition);//获取map对象
//        group.get(groupPosition).get("Group");//获取key值为Group的数据
        return group.get(groupPosition).get("Group");
    }

    /**
     * 获取指定组中的指定子元素数据。
     *
     * @param groupPosition
     * @param childPosition
     * @return
     */
    @Override
    public Object getChild(int groupPosition, int childPosition) {
//        child.get(groupPosition);//是得到groupPosition处的list对象
//        child.get(groupPosition).get(childPosition);//得到child的map对象
//        child.get(groupPosition).get(childPosition).get("child");//是得到key值为Child的值
        return child.get(groupPosition).get(childPosition).get("child");
    }

    /**
     * 获取指定组的Id
     *
     * @param groupPosition
     * @return
     */
    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    /**
     * 获取指定组中的指定子元素ID，这个ID在组里一定是唯一的。联合ID（getCombinedChildId(long, long)）在所有条*目（所有组和所有元素）中也是唯一的。
     *
     * @param groupPosition
     * @param childPosition
     * @return
     */
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;//子元素的位置
    }

    /**
     * 组和子元素是否持有稳定的ID,也就是底层数据的改变不会影响到它们。
     *
     * @return
     */
    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        ViewHolderGroup viewHolder;
        if (convertView == null) {//判断convertView是否为空，convertView是RecycleBean调用getScrapView函数得到废弃已缓存的view
            viewHolder = new ViewHolderGroup();//初始化控件管理器对象
            convertView = inflater.inflate(R.layout.activity_parent_layout, null);//重新加载布局
            viewHolder.m_expandable_text1 = (TextView) convertView.findViewById(R.id.m_expandable_text);//给组元素绑定ID
            viewHolder.m_expandable_right = (ImageView) convertView.findViewById(R.id.m_expandable_right);//给组元素箭头绑定ID
            convertView.setTag(viewHolder);//convertView将viewHolder设置到Tag中，以便再次绘制ExpandableListView时从Tag中取出viewHolder;
        } else {//如果convertView不为空，即getScrapView得到废弃已缓存的view，从Tag中取出之前存入的viewHolder
            viewHolder = (ViewHolderGroup) convertView.getTag();
        }
        viewHolder.m_expandable_text1.setText(getGroup(groupPosition).toString());//设置组值
        /**
         * 判断是否点击了列表
         */
        if (isExpanded) {//如果组是展开状态，箭头向下
            viewHolder.m_expandable_right.setImageResource(R.mipmap.a18);
        } else {//如果组是伸缩状态，箭头向右
            viewHolder.m_expandable_right.setImageResource(R.mipmap.right);
        }
        return convertView;//返回得到的指定组的视图对象
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        return null;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    /**
     * 组控件管理器(activity_parent_layout)
     */
    class ViewHolderGroup {
        TextView m_expandable_text1;
        ImageView m_expandable_right;
    }

    /**
     * 子控件管理器(activity_child_layout)
     */
    class ViewHolderChild {
        TextView m_expandable_text;
    }
}
