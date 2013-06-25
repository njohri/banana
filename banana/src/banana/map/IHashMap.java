package banana.map;

import banana.memory.IBuffer;
import banana.memory.IMemAllocator;
import banana.memory.IPrimitiveAccess;

public interface IHashMap extends IPrimitiveAccess {

  /**
   * @return true if empty
   */
  public boolean isEmpty();

  public int createRecord(long key, int size);

  public int createRecord(long key, IBuffer value);

  /**
   * Reallocate the memory this value can hold. this is using the IMemAllocator
   * realloc function which is guaranteed to make almost no copies of data.
   *
   * @param key record key to realloc
   * @param newSize new size (can be smaller or bigger than current allocation)
   * @return new record_id for the key, in some cases the record id will change after a realloc.
   */
  public int reallocRecord(long key, int newSize);

  public boolean containsKey(long key);

  public int findRecord(long key);

  public boolean remove(long key);

  public void clear();

  public int getCapacity();

  /**
   * @return number of records used in this hash-map
   */
  public int size();

  public double getLoadFactor();

  /**
   * @param d growth factor. 0 to disable growth and d > 1 to support growth by
   *          this factor.
   */
  public void setGrowthFactor(double d);

  /**
   * Returns an estimation of the number of bytes this HashMap is using
   */
  public long computeMemoryUsage();

  /**
   * Visits each record in the hashtable, and enables the caller to run code for
   * each record
   *
   * @param visitor
   */
  public void visitRecords(HashMapVisitor visitor);

  public void setDebug(DebugLevel level);

  public IMemAllocator getAllocator();
}