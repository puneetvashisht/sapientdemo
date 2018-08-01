package java102.synchronizers;

import java.util.concurrent.Semaphore;

final class Pool
{
   public static final int MAX_AVAILABLE = 10;

   private Semaphore available = new Semaphore(MAX_AVAILABLE, true);
   private String[] items;
   private boolean[] used = new boolean[MAX_AVAILABLE];

   Pool()
   {
      items = new String[MAX_AVAILABLE];
      for (int i = 0; i < items.length; i++)
         items[i] = "ITEM"+i;
   }

   String getItem() throws InterruptedException
   {
      available.acquire();
      return getNextAvailableItem();
   }

   void putItem(String item)
   {
      if (markAsUnused(item))
         available.release();
   }

   
   // why synchronization to maintain pool state??
   private synchronized String getNextAvailableItem()
   {
      for (int i = 0; i < MAX_AVAILABLE; ++i)
      {
         if (!used[i])
         {
            used[i] = true;
            return items[i];
         }
      }
      return null; // not reached
   }

   private synchronized boolean markAsUnused(String item)
   {
      for (int i = 0; i < MAX_AVAILABLE; ++i)
      {
         if (item == items[i])
         {
            if (used[i])
            {
               used[i] = false;
               return true;
            }
            else
               return false;
         }
      }
      return false;
   }
}