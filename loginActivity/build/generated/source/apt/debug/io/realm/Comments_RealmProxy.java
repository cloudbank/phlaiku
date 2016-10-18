package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.RealmObjectSchema;
import io.realm.RealmSchema;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.LinkView;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.SharedRealm;
import io.realm.internal.Table;
import io.realm.internal.TableOrView;
import io.realm.internal.android.JsonUtils;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Comments_RealmProxy extends com.anubis.flickr.models.Comments_
    implements RealmObjectProxy, Comments_RealmProxyInterface {

    static final class Comments_ColumnInfo extends ColumnInfo
        implements Cloneable {

        public long photoIdIndex;
        public long commentsListIndex;

        Comments_ColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(2);
            this.photoIdIndex = getValidColumnIndex(path, table, "Comments_", "photoId");
            indicesMap.put("photoId", this.photoIdIndex);
            this.commentsListIndex = getValidColumnIndex(path, table, "Comments_", "commentsList");
            indicesMap.put("commentsList", this.commentsListIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final Comments_ColumnInfo otherInfo = (Comments_ColumnInfo) other;
            this.photoIdIndex = otherInfo.photoIdIndex;
            this.commentsListIndex = otherInfo.commentsListIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final Comments_ColumnInfo clone() {
            return (Comments_ColumnInfo) super.clone();
        }

    }
    private Comments_ColumnInfo columnInfo;
    private ProxyState proxyState;
    private RealmList<com.anubis.flickr.models.Comment> commentsListRealmList;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("photoId");
        fieldNames.add("commentsList");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    Comments_RealmProxy() {
        if (proxyState == null) {
            injectObjectContext();
        }
        proxyState.setConstructionFinished();
    }

    private void injectObjectContext() {
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (Comments_ColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState(com.anubis.flickr.models.Comments_.class, this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @SuppressWarnings("cast")
    public String realmGet$photoId() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.photoIdIndex);
    }

    public void realmSet$photoId(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.photoIdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.photoIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.photoIdIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.photoIdIndex, value);
    }

    public RealmList<com.anubis.flickr.models.Comment> realmGet$commentsList() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (commentsListRealmList != null) {
            return commentsListRealmList;
        } else {
            LinkView linkView = proxyState.getRow$realm().getLinkList(columnInfo.commentsListIndex);
            commentsListRealmList = new RealmList<com.anubis.flickr.models.Comment>(com.anubis.flickr.models.Comment.class, linkView, proxyState.getRealm$realm());
            return commentsListRealmList;
        }
    }

    public void realmSet$commentsList(RealmList<com.anubis.flickr.models.Comment> value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("commentsList")) {
                return;
            }
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<com.anubis.flickr.models.Comment> original = value;
                value = new RealmList<com.anubis.flickr.models.Comment>();
                for (com.anubis.flickr.models.Comment item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealm(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        LinkView links = proxyState.getRow$realm().getLinkList(columnInfo.commentsListIndex);
        links.clear();
        if (value == null) {
            return;
        }
        for (RealmModel linkedObject : (RealmList<? extends RealmModel>) value) {
            if (!(RealmObject.isManaged(linkedObject) && RealmObject.isValid(linkedObject))) {
                throw new IllegalArgumentException("Each element of 'value' must be a valid managed object.");
            }
            if (((RealmObjectProxy)linkedObject).realmGet$proxyState().getRealm$realm() != proxyState.getRealm$realm()) {
                throw new IllegalArgumentException("Each element of 'value' must belong to the same Realm.");
            }
            links.add(((RealmObjectProxy)linkedObject).realmGet$proxyState().getRow$realm().getIndex());
        }
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("Comments_")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("Comments_");
            realmObjectSchema.add(new Property("photoId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            if (!realmSchema.contains("Comment")) {
                CommentRealmProxy.createRealmObjectSchema(realmSchema);
            }
            realmObjectSchema.add(new Property("commentsList", RealmFieldType.LIST, realmSchema.get("Comment")));
            return realmObjectSchema;
        }
        return realmSchema.get("Comments_");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_Comments_")) {
            Table table = sharedRealm.getTable("class_Comments_");
            table.addColumn(RealmFieldType.STRING, "photoId", Table.NULLABLE);
            if (!sharedRealm.hasTable("class_Comment")) {
                CommentRealmProxy.initTable(sharedRealm);
            }
            table.addColumnLink(RealmFieldType.LIST, "commentsList", sharedRealm.getTable("class_Comment"));
            table.setPrimaryKey("");
            return table;
        }
        return sharedRealm.getTable("class_Comments_");
    }

    public static Comments_ColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_Comments_")) {
            Table table = sharedRealm.getTable("class_Comments_");
            final long columnCount = table.getColumnCount();
            if (columnCount != 2) {
                if (columnCount < 2) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 2 but was " + columnCount);
                }
                if (allowExtraColumns) {
                    RealmLog.debug("Field count is more than expected - expected 2 but was %1$d", columnCount);
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 2 but was " + columnCount);
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
            for (long i = 0; i < 2; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            final Comments_ColumnInfo columnInfo = new Comments_ColumnInfo(sharedRealm.getPath(), table);

            if (!columnTypes.containsKey("photoId")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'photoId' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("photoId") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'photoId' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.photoIdIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'photoId' is required. Either set @Required to field 'photoId' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("commentsList")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'commentsList'");
            }
            if (columnTypes.get("commentsList") != RealmFieldType.LIST) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Comment' for field 'commentsList'");
            }
            if (!sharedRealm.hasTable("class_Comment")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing class 'class_Comment' for field 'commentsList'");
            }
            Table table_1 = sharedRealm.getTable("class_Comment");
            if (!table.getLinkTarget(columnInfo.commentsListIndex).hasSameSchema(table_1)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid RealmList type for field 'commentsList': '" + table.getLinkTarget(columnInfo.commentsListIndex).getName() + "' expected - was '" + table_1.getName() + "'");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'Comments_' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_Comments_";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.anubis.flickr.models.Comments_ createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(1);
        if (json.has("commentsList")) {
            excludeFields.add("commentsList");
        }
        com.anubis.flickr.models.Comments_ obj = realm.createObjectInternal(com.anubis.flickr.models.Comments_.class, true, excludeFields);
        if (json.has("photoId")) {
            if (json.isNull("photoId")) {
                ((Comments_RealmProxyInterface) obj).realmSet$photoId(null);
            } else {
                ((Comments_RealmProxyInterface) obj).realmSet$photoId((String) json.getString("photoId"));
            }
        }
        if (json.has("commentsList")) {
            if (json.isNull("commentsList")) {
                ((Comments_RealmProxyInterface) obj).realmSet$commentsList(null);
            } else {
                ((Comments_RealmProxyInterface) obj).realmGet$commentsList().clear();
                JSONArray array = json.getJSONArray("commentsList");
                for (int i = 0; i < array.length(); i++) {
                    com.anubis.flickr.models.Comment item = CommentRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    ((Comments_RealmProxyInterface) obj).realmGet$commentsList().add(item);
                }
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.anubis.flickr.models.Comments_ createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        com.anubis.flickr.models.Comments_ obj = new com.anubis.flickr.models.Comments_();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("photoId")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((Comments_RealmProxyInterface) obj).realmSet$photoId(null);
                } else {
                    ((Comments_RealmProxyInterface) obj).realmSet$photoId((String) reader.nextString());
                }
            } else if (name.equals("commentsList")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((Comments_RealmProxyInterface) obj).realmSet$commentsList(null);
                } else {
                    ((Comments_RealmProxyInterface) obj).realmSet$commentsList(new RealmList<com.anubis.flickr.models.Comment>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        com.anubis.flickr.models.Comment item = CommentRealmProxy.createUsingJsonStream(realm, reader);
                        ((Comments_RealmProxyInterface) obj).realmGet$commentsList().add(item);
                    }
                    reader.endArray();
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.anubis.flickr.models.Comments_ copyOrUpdate(Realm realm, com.anubis.flickr.models.Comments_ object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.anubis.flickr.models.Comments_) cachedRealmObject;
        } else {
            return copy(realm, object, update, cache);
        }
    }

    public static com.anubis.flickr.models.Comments_ copy(Realm realm, com.anubis.flickr.models.Comments_ newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.anubis.flickr.models.Comments_) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.anubis.flickr.models.Comments_ realmObject = realm.createObjectInternal(com.anubis.flickr.models.Comments_.class, false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((Comments_RealmProxyInterface) realmObject).realmSet$photoId(((Comments_RealmProxyInterface) newObject).realmGet$photoId());

            RealmList<com.anubis.flickr.models.Comment> commentsListList = ((Comments_RealmProxyInterface) newObject).realmGet$commentsList();
            if (commentsListList != null) {
                RealmList<com.anubis.flickr.models.Comment> commentsListRealmList = ((Comments_RealmProxyInterface) realmObject).realmGet$commentsList();
                for (int i = 0; i < commentsListList.size(); i++) {
                    com.anubis.flickr.models.Comment commentsListItem = commentsListList.get(i);
                    com.anubis.flickr.models.Comment cachecommentsList = (com.anubis.flickr.models.Comment) cache.get(commentsListItem);
                    if (cachecommentsList != null) {
                        commentsListRealmList.add(cachecommentsList);
                    } else {
                        commentsListRealmList.add(CommentRealmProxy.copyOrUpdate(realm, commentsListList.get(i), update, cache));
                    }
                }
            }

            return realmObject;
        }
    }

    public static long insert(Realm realm, com.anubis.flickr.models.Comments_ object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.anubis.flickr.models.Comments_.class);
        long tableNativePtr = table.getNativeTablePointer();
        Comments_ColumnInfo columnInfo = (Comments_ColumnInfo) realm.schema.getColumnInfo(com.anubis.flickr.models.Comments_.class);
        long rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
        cache.put(object, rowIndex);
        String realmGet$photoId = ((Comments_RealmProxyInterface)object).realmGet$photoId();
        if (realmGet$photoId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.photoIdIndex, rowIndex, realmGet$photoId, false);
        }

        RealmList<com.anubis.flickr.models.Comment> commentsListList = ((Comments_RealmProxyInterface) object).realmGet$commentsList();
        if (commentsListList != null) {
            long commentsListNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.commentsListIndex, rowIndex);
            for (com.anubis.flickr.models.Comment commentsListItem : commentsListList) {
                Long cacheItemIndexcommentsList = cache.get(commentsListItem);
                if (cacheItemIndexcommentsList == null) {
                    cacheItemIndexcommentsList = CommentRealmProxy.insert(realm, commentsListItem, cache);
                }
                LinkView.nativeAdd(commentsListNativeLinkViewPtr, cacheItemIndexcommentsList);
            }
            LinkView.nativeClose(commentsListNativeLinkViewPtr);
        }

        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.anubis.flickr.models.Comments_.class);
        long tableNativePtr = table.getNativeTablePointer();
        Comments_ColumnInfo columnInfo = (Comments_ColumnInfo) realm.schema.getColumnInfo(com.anubis.flickr.models.Comments_.class);
        com.anubis.flickr.models.Comments_ object = null;
        while (objects.hasNext()) {
            object = (com.anubis.flickr.models.Comments_) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
                cache.put(object, rowIndex);
                String realmGet$photoId = ((Comments_RealmProxyInterface)object).realmGet$photoId();
                if (realmGet$photoId != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.photoIdIndex, rowIndex, realmGet$photoId, false);
                }

                RealmList<com.anubis.flickr.models.Comment> commentsListList = ((Comments_RealmProxyInterface) object).realmGet$commentsList();
                if (commentsListList != null) {
                    long commentsListNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.commentsListIndex, rowIndex);
                    for (com.anubis.flickr.models.Comment commentsListItem : commentsListList) {
                        Long cacheItemIndexcommentsList = cache.get(commentsListItem);
                        if (cacheItemIndexcommentsList == null) {
                            cacheItemIndexcommentsList = CommentRealmProxy.insert(realm, commentsListItem, cache);
                        }
                        LinkView.nativeAdd(commentsListNativeLinkViewPtr, cacheItemIndexcommentsList);
                    }
                    LinkView.nativeClose(commentsListNativeLinkViewPtr);
                }

            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.anubis.flickr.models.Comments_ object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.anubis.flickr.models.Comments_.class);
        long tableNativePtr = table.getNativeTablePointer();
        Comments_ColumnInfo columnInfo = (Comments_ColumnInfo) realm.schema.getColumnInfo(com.anubis.flickr.models.Comments_.class);
        long rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
        cache.put(object, rowIndex);
        String realmGet$photoId = ((Comments_RealmProxyInterface)object).realmGet$photoId();
        if (realmGet$photoId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.photoIdIndex, rowIndex, realmGet$photoId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.photoIdIndex, rowIndex, false);
        }

        long commentsListNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.commentsListIndex, rowIndex);
        LinkView.nativeClear(commentsListNativeLinkViewPtr);
        RealmList<com.anubis.flickr.models.Comment> commentsListList = ((Comments_RealmProxyInterface) object).realmGet$commentsList();
        if (commentsListList != null) {
            for (com.anubis.flickr.models.Comment commentsListItem : commentsListList) {
                Long cacheItemIndexcommentsList = cache.get(commentsListItem);
                if (cacheItemIndexcommentsList == null) {
                    cacheItemIndexcommentsList = CommentRealmProxy.insertOrUpdate(realm, commentsListItem, cache);
                }
                LinkView.nativeAdd(commentsListNativeLinkViewPtr, cacheItemIndexcommentsList);
            }
        }
        LinkView.nativeClose(commentsListNativeLinkViewPtr);

        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.anubis.flickr.models.Comments_.class);
        long tableNativePtr = table.getNativeTablePointer();
        Comments_ColumnInfo columnInfo = (Comments_ColumnInfo) realm.schema.getColumnInfo(com.anubis.flickr.models.Comments_.class);
        com.anubis.flickr.models.Comments_ object = null;
        while (objects.hasNext()) {
            object = (com.anubis.flickr.models.Comments_) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
                cache.put(object, rowIndex);
                String realmGet$photoId = ((Comments_RealmProxyInterface)object).realmGet$photoId();
                if (realmGet$photoId != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.photoIdIndex, rowIndex, realmGet$photoId, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.photoIdIndex, rowIndex, false);
                }

                long commentsListNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.commentsListIndex, rowIndex);
                LinkView.nativeClear(commentsListNativeLinkViewPtr);
                RealmList<com.anubis.flickr.models.Comment> commentsListList = ((Comments_RealmProxyInterface) object).realmGet$commentsList();
                if (commentsListList != null) {
                    for (com.anubis.flickr.models.Comment commentsListItem : commentsListList) {
                        Long cacheItemIndexcommentsList = cache.get(commentsListItem);
                        if (cacheItemIndexcommentsList == null) {
                            cacheItemIndexcommentsList = CommentRealmProxy.insertOrUpdate(realm, commentsListItem, cache);
                        }
                        LinkView.nativeAdd(commentsListNativeLinkViewPtr, cacheItemIndexcommentsList);
                    }
                }
                LinkView.nativeClose(commentsListNativeLinkViewPtr);

            }
        }
    }

    public static com.anubis.flickr.models.Comments_ createDetachedCopy(com.anubis.flickr.models.Comments_ realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.anubis.flickr.models.Comments_ unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.anubis.flickr.models.Comments_)cachedObject.object;
            } else {
                unmanagedObject = (com.anubis.flickr.models.Comments_)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.anubis.flickr.models.Comments_();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, unmanagedObject));
        }
        ((Comments_RealmProxyInterface) unmanagedObject).realmSet$photoId(((Comments_RealmProxyInterface) realmObject).realmGet$photoId());

        // Deep copy of commentsList
        if (currentDepth == maxDepth) {
            ((Comments_RealmProxyInterface) unmanagedObject).realmSet$commentsList(null);
        } else {
            RealmList<com.anubis.flickr.models.Comment> managedcommentsListList = ((Comments_RealmProxyInterface) realmObject).realmGet$commentsList();
            RealmList<com.anubis.flickr.models.Comment> unmanagedcommentsListList = new RealmList<com.anubis.flickr.models.Comment>();
            ((Comments_RealmProxyInterface) unmanagedObject).realmSet$commentsList(unmanagedcommentsListList);
            int nextDepth = currentDepth + 1;
            int size = managedcommentsListList.size();
            for (int i = 0; i < size; i++) {
                com.anubis.flickr.models.Comment item = CommentRealmProxy.createDetachedCopy(managedcommentsListList.get(i), nextDepth, maxDepth, cache);
                unmanagedcommentsListList.add(item);
            }
        }
        return unmanagedObject;
    }

    @Override
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Comments_ = [");
        stringBuilder.append("{photoId:");
        stringBuilder.append(realmGet$photoId() != null ? realmGet$photoId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{commentsList:");
        stringBuilder.append("RealmList<Comment>[").append(realmGet$commentsList().size()).append("]");
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comments_RealmProxy aComments_ = (Comments_RealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aComments_.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aComments_.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aComments_.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
