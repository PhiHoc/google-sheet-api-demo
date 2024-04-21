# Demo Google Sheets API


## Steps:

1. **Create a Google Project and Enable Google Sheets API**

2. **Get Credentials ID**

3. **Write Code for CRUD Operations on Sheets**

4. **Write Test Cases to Fetch Product List from Demo Website and Save to Google Sheets (Product name and price)**
   - Link Demo website: https://vikwp.com/demo/vikrentitems/products-list/

## Methods:

### 1. `getCredentials(HTTP_TRANSPORT: NetHttpTransport): Credential`
   - **Description:** Creates an authorized Credential object required for accessing Google Sheets API.
   - **Parameters:**
     - `HTTP_TRANSPORT`: The network HTTP Transport.
   - **Returns:** An authorized Credential object.
   - **Throws:** IOException if the credentials.json file cannot be found.

### 2. `createSpreadsheet(title: String): String`
   - **Description:** Creates a new spreadsheet with the specified title.
   - **Parameters:**
     - `title`: The name of the sheet to be created.
   - **Returns:** The ID of the newly created spreadsheet.
   - **Throws:** IOException if the credentials file is not found.

### 3. `appendValuesToSpreadSheet(spreadsheetId: String, range: String, valueInputOption: String, values: List<List<Object>>): AppendValuesResponse`
   - **Description:** Appends values to a specified range in a spreadsheet.
   - **Parameters:**
     - `spreadsheetId`: ID of the spreadsheet.
     - `range`: Range of cells of the spreadsheet.
     - `valueInputOption`: Determines how input data should be interpreted.
     - `values`: List of rows of values to input.
   - **Returns:** Spreadsheet with appended values.
   - **Throws:** IOException if the credentials file is not found.

### 4. `getValuesFromSpreadSheet(spreadsheetId: String, range: String): ValueRange`
   - **Description:** Returns a list of values from a specified range in a spreadsheet.
   - **Parameters:**
     - `spreadsheetId`: ID of the spreadsheet.
     - `range`: Range of cells of the spreadsheet.
   - **Returns:** Values in the specified range.
   - **Throws:** IOException if the credentials file is not found.


## Result:
  - Link sheet: https://docs.google.com/spreadsheets/d/1EKyQHCXYeXEEalHGsn2KPDvFk1WUkkvU7xqGYvszfNY/edit?usp=sharing
    
![image](https://github.com/PhiHoc/google-sheet-api-demo/assets/95021040/0bc62dfe-2344-4ab2-91f2-e5ddb111650f)


