import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.hills_studio.R

internal class MembersListAdapter internal constructor(
    context: Context,
    private val resource: Int,
    private val membersList: Array<String>?
) : ArrayAdapter<MembersListAdapter.ItemHolder>(context, resource) {

    override fun getCount(): Int {
        return if (this.membersList != null) this.membersList.size else 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView

        val holder: ItemHolder
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(resource, null)
            holder = ItemHolder()
            holder.memberName = convertView!!.findViewById(R.id.memberName)
            holder.memberAvatar = convertView.findViewById(R.id.memberAvatar)
            convertView.tag = holder
        } else {
            holder = convertView.tag as ItemHolder
        }

        holder.memberName!!.text = this.membersList!![position]
        holder.memberAvatar!!.setImageResource(R.mipmap.ic_launcher)

        return convertView
    }

    internal class ItemHolder {
        var memberName: TextView? = null
        var memberAvatar: ImageView? = null
    }
}
