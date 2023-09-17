from typing import List

def findWays(arr: List[int], k: int) -> int:
    # Write your code here.

    def nn(ind,target,arr,dp):


        if(target==0):
            return 1


        if(ind==0):
            if(arr[0]==target):
                return 1
            else:
                return 0
        
        
        if(dp[ind][target]!=-1):
            return dp[ind][target]

        notpick = nn(ind-1,target,arr,dp)

        pick = 0

        if(target>=arr[ind]):
            pick = nn(ind-1,target-arr[ind],arr,dp)
        
        dp[ind][target] = pick+notpick

        return dp[ind][target]
    
    n = len(arr)

    dp = [[-1 for i in range(k+1)] for j in range(n)]

    res = nn(n-1,k,arr,dp)

    res = res % (10 ** 9+7)

    return res
    
