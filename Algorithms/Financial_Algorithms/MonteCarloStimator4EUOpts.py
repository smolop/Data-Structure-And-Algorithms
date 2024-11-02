import numpy as np
import math


class MonteCarloEstimator4EUOpts(object):
    '''
    S0 = Initial stock index level 
    T = Maturity
    K = strike price of european call option
    r = riskless short rate
    sigma = constant volatility
    '''
    def __init__(self, *args):
        super (MonteCarloEstimator4EUOpts, self).__init__(*args)
        
    def solve(S0: float, K: float, T: int, r: float, sigma: float):
        '''
        S0 = Initial stock index level 
        K = strike price of european call option
        T = Maturity
        r = riskless short rate
        sigma = constant volatility
        '''
        I: int = 100000
        z: int = np.random.standard_normal(I)
        ST: float = S0 * math.exp((r - 0.5 * math.pow(sigma, 2)) * T + sigma * math.sqrt(T) * z)
        hT: float = np.maximum(ST - K, 0)
        C0: float = math.exp(-r * T) * sum(hT) / I

        print(f"Value of the european call option {C0}")


def main():
    S0 = 100.0
    K = 105.0
    T = 1
    r = 0.05
    sigma = 0.2
    MonteCarloEstimator4EUOpts.solve(S0, K, T, r, sigma)


if __name__ == '__main__':
    main()