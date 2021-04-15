import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.hills_studio.R
import com.hills_studio.User
import com.squareup.picasso.Picasso

internal class MembersListAdapter internal constructor(
    context: Context,
    private val resource: Int,
    private val membersList: ArrayList<User>
) : ArrayAdapter<MembersListAdapter.ItemHolder>(context, resource) {

    override fun getCount(): Int {
        return this.membersList.size
    }

    override fun getView(position: Int, givenConvertView: View?, parent: ViewGroup): View {
        var convertView = givenConvertView

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

        holder.memberName!!.text = membersList[position].fullName
        Picasso.get().load(membersList[position].avatar).into(holder.memberAvatar)

        return convertView
    }

    internal class ItemHolder {
        var memberName: TextView? = null
        var memberAvatar: ImageView? = null
    }
}
