package di.applications_dl;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CollectionDiMain {
    private List addressList;
    private Set addressSet;
    private Map addressMap;
    private Properties addressProp;

    public List getAddressList() {
        System.out.println("addressList中有:" + addressList);
        return addressList;
    }

    public void setAddressList(List addressList) {
        this.addressList = addressList;
    }

    public Set getAddressSet() {
        System.out.println("addressSet中有:" + addressSet);
        return addressSet;
    }

    public void setAddressSet(Set addressSet) {
        this.addressSet = addressSet;
    }

    public Map getAddressMap() {
        System.out.println("addressMap中有:" + addressMap);
        return addressMap;
    }

    public void setAddressMap(Map addressMap) {
        this.addressMap = addressMap;
    }

    public Properties getAddressProp() {
        System.out.println("addressProp中有:" + addressProp);
        return addressProp;
    }

    public void setAddressProp(Properties addressProp) {
        this.addressProp = addressProp;
    }

}
